package com.dong.genadmin.service.impl;

import com.dong.genadmin.generator.mapper.SysUserMapper;
import com.dong.genadmin.generator.model.SysUser;
import com.dong.genadmin.generator.model.SysUserRole;
import com.dong.genadmin.manual.mapper.MSysUserMapper;
import com.dong.genadmin.manual.mapper.MSysUserRoleMapper;
import com.dong.genadmin.manual.model.MSysMenu;
import com.dong.genadmin.service.SysMenuService;
import com.dong.genadmin.service.SysUserService;
import com.dong.gencore.page.MybatisPageHelper;
import com.dong.gencore.page.PageRequest;
import com.dong.gencore.page.PageResult;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname SysUserServiceImpl
 * @Description TODO
 * @Date 2019/9/30 14:22
 * @Created by dong
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private MSysUserMapper mSysUserMapper;
    @Resource
    private SysMenuService sysMenuService;  // 获取菜单中的权限
    @Resource
    private MSysUserRoleMapper mSysUserRoleMapper;  // 提供查询用户角色

    @Override
    public List<SysUser> findByName(String name) {
        return mSysUserMapper.findByName(name);
    }

    @Override
    public Set<String> findPermissions(String name) {
        Set<String> perms = new HashSet<>();
        List<MSysMenu> mSysMenus = sysMenuService.findByUserName(name);
        for (MSysMenu mSysMenu : mSysMenus) {
            if (mSysMenu.getPerms() != null && !"".equals(mSysMenu.getPerms())) {
                perms.add(mSysMenu.getPerms());
            }
        }
        return perms;
    }

    @Override
    public List<SysUserRole> findUserRoles(Long userId) {
        return mSysUserRoleMapper.findUserRoles(userId);
    }

    @Override
    public int save(SysUser record) {
        // 只处理了insert，暂未考虑update
        return sysUserMapper.insert(record);
    }

    @Override
    public int delete(SysUser record) {
        return sysUserMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysUser> records) {
        for (SysUser record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysUser findById(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        //这里也可以选择改MSysUserMapper的findPage where条件 del_flag 为 1
//      return MybatisPageHelper.findPage(pageRequest, sysUserMapper,"selectAllUsers",(byte)0);
        return MybatisPageHelper.findPage(pageRequest, mSysUserMapper);
    }

    @Override
    public List<SysUser> findAllUsers() {
        return sysUserMapper.selectAllUsers((byte)0);
    }

    @Override
    public void exportUsers(HttpServletResponse response,PageRequest pageRequest) {

        PageResult result = MybatisPageHelper.findPage(pageRequest, mSysUserMapper);
        List<SysUser> sysUsers = (List<SysUser>) result.getContent();

        if (sysUsers != null && sysUsers.size() > 0) {
            String fileName = "所有用户_" + DateTimeFormatter.ofPattern("yyyyMMdd").format(ZonedDateTime.now()) + ".xlsx";
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("信息表");
            //创建styleHead
            CellStyle styleHead = workbook.createCellStyle();
            styleHead.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());//背景色
            styleHead.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            styleHead.setAlignment(HorizontalAlignment.CENTER);//水平居中
            XSSFFont font = workbook.createFont();
            font.setBold(true);//加粗
            font.setFontHeight((short) 240);//字体大小
            font.setFontName("宋体");
            styleHead.setFont(font);

//            CellStyle styleContent = workbook.createCellStyle();
//            styleContent.setAlignment(HorizontalAlignment.CENTER);//水平居中
//            XSSFFont fontContent = workbook.createFont();
//            fontContent.setFontName("宋体");
//            styleContent.setFont(fontContent);

            sheet.setColumnWidth(0, 2000);
            sheet.setColumnWidth(1, 3500);
            sheet.setColumnWidth(2, 2000);
            sheet.setColumnWidth(3, 3500);
            sheet.setColumnWidth(4, 3500);
            sheet.setColumnWidth(5, 5500);
            sheet.setColumnWidth(6, 3500);
            sheet.setColumnWidth(7, 3500);
            sheet.setColumnWidth(8, 2000);
            sheet.setColumnWidth(9, 3500);
            sheet.setColumnWidth(10, 3500);
            sheet.setColumnWidth(11, 3500);
            sheet.setColumnWidth(12, 3500);
            sheet.setColumnWidth(13, 3500);
            sheet.setColumnWidth(14, 3500);

            //新增数据行，并且设置单元格数据
            int rowNum = 1;

            String[] headers = {"编号", "用户名", "昵称", "头像", "密码", "加密盐", "邮箱", "手机号", "状态", "机构ID", "创建人", "创建时间", "更新人", "更新时间", "是否删除"};
            //headers表示excel表中第一行的表头
            XSSFRow row = sheet.createRow(0);

            //在excel表中添加表头
            for (int i = 0; i < headers.length; i++) {
                XSSFCell cell = row.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(styleHead);
            }

            //在表中存放查询到的数据放入对应的列
            for (SysUser user : sysUsers) {
                XSSFRow row1 = sheet.createRow(rowNum);
                row1.createCell(0).setCellValue(user.getId());
                row1.createCell(1).setCellValue(user.getName());
                row1.createCell(2).setCellValue(user.getNickName());
                row1.createCell(3).setCellValue(user.getAvatar());
                row1.createCell(4).setCellValue(user.getPassword());
                row1.createCell(5).setCellValue(user.getSalt());
                row1.createCell(6).setCellValue(user.getEmail());
                row1.createCell(7).setCellValue(user.getMobile());
                row1.createCell(8).setCellValue(user.getStatus());
                row1.createCell(9).setCellValue(user.getDeptId());
                row1.createCell(10).setCellValue(user.getCreateBy());
                row1.createCell(11).setCellValue(user.getCreateTime());
                row1.createCell(12).setCellValue(user.getLastUpdateBy());
                row1.createCell(13).setCellValue(user.getLastUpdateTime());
                row1.createCell(14).setCellValue(user.getDelFlag());
                rowNum++;
            }
            try {
                response.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"");
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                response.flushBuffer();
                workbook.write(response.getOutputStream());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
