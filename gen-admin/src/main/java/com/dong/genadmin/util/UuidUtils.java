package com.dong.genadmin.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class UuidUtils {
    private static final int maxCount = 99999;
    private static final int minCount = 10000;
    private static long countor = minCount;

    //20201126154101522 18368 11008101  时间戳+自增数+ip后3位+端口  idc规则

    public static String getUUID() {
        StringBuilder uuid = new StringBuilder(36).append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Timestamp(System.currentTimeMillis())));
        long tmp = 0;
        synchronized (UuidUtils.class) {
            tmp = ++countor > maxCount ? countor = minCount : countor;
        }
        return uuid.append(tmp).append("11008101").toString();
    }

    public static void main(String[] args) {
        while (true){
            String uuid = getUUID();
            String  topDataFather ="{\"BUSI_CODE\":null,\"BUSI_RETCODE\":\"0000\",\"BUSI_RETMSG\":\"\",\"CUT_OFF_DAY\":20201126,\"HDOMAIN_ID\":\"CASP\",\"HPARTY_DUNS\":\"MNQ\",\"HPARTY_IP\":\"10.124.164.110\",\"HPARTY_PORT\":20080,\"HPARTY_PROC_LEN\":5,\"HREGION_NO\":\"MN01\",\"HRSP_CONTENT\":\"{\\\"rspCode\\\":\\\"0000\\\",\\\"rspDesc\\\":\\\"模拟器返回成功\\\"}\\n\\n\",\"HSN_NODE_IP\":\"10.124.164.110\",\"HSN_NODE_PORT\":19602,\"HSN_PROC_LEN\":8,\"HSN_REQ_RECV_TIME\":\"2020-11-26 15:41:01.531\",\"HSN_REQ_SEND_TIME\":\"2020-11-26 15:41:01.533\",\"IS_LOG_FILE\":0,\"ODOMAIN_ID\":\"CASP\",\"OPARTY_BUSI_SEQ\":\"\",\"OPARTY_DUNS\":\"\",\"OPARTY_IP\":\"10.124.164.110\",\"OPARTY_REQ_TIME\":\"\",\"OPR_NAME\":\"json_jiangSU_microtest_hangon001_sub\",\"OSN_NODE_IP\":\"10.124.164.110\",\"OSN_NODE_PORT\":8101,\"OSN_REQ_PROC_LEN\":0,\"OSN_REQ_RECV_DATA_LEN\":\"0\",\"OSN_REQ_RECV_TIME\":\"2020-11-26 15:41:01.522\",\"PARENT_TRANS_IDC\":"+uuid+",\"REQ_CONTENT\":\"\",\"RETRY_COUNT\":\"0\",\"ROUTE_TYPE1\":\"\",\"ROUTE_TYPE2\":\"\",\"ROUTE_VALUE1\":\"\",\"ROUTE_VALUE2\":\"\",\"RSP_CODE\":\"0000\",\"RSP_DESC\":\"\",\"SC_NODE_IP\":\"10.124.164.110\",\"SC_NODE_PORT\":9102,\"SC_REQ_PROC_LEN\":0,\"SC_REQ_RECV_TIME\":\"2020-11-26 15:41:01.527\",\"SC_RSP_PROC_LEN\":1,\"SC_RSP_RECV_TIME\":\"2020-11-26 15:41:01.539\",\"SERVICE_VERSION\":\"1\",\"SVC_NAME\":\"json_jiangSU_microtest_hangon001_sub\",\"SVC_NUMBER\":0,\"TRANS_IDC\":\"202011261541015271195311009101\",\"TRANS_IDH\":\"\",\"TRANS_IDO\":\"20201104175326938563726\",\"USER_ACCT\":\"\"}";
            String  topDataSon ="{\"BUSI_CODE\":\"\",\"BUSI_RETCODE\":\"0000\",\"BUSI_RETMSG\":\"\",\"CUT_OFF_DAY\":20201126,\"HDOMAIN_ID\":\"CASP\",\"HPARTY_DUNS\":\"\",\"HPARTY_IP\":\"\",\"HPARTY_PORT\":0,\"HPARTY_PROC_LEN\":13,\"HREGION_NO\":\"\",\"HRSP_CONTENT\":\"{\\\"UNI_BSS_HEAD\\\":{\\\"RESP_DESC\\\":\\\"Success\\\",\\\"TRANS_ID\\\":\\\"20201104175326938563726\\\",\\\"TIMESTAMP\\\":\\\"2020-11-04 17:53:26 938\\\",\\\"RESP_CODE\\\":\\\"00000\\\",\\\"APP_ID\\\":\\\"qJTRmWbwBi\\\"},\\\"UNI_BSS_ATTACHED\\\":{\\\"MEDIA_INFO\\\":\\\"kvIJdrf9gBF26bDhcLmC39EvGA4vEKs6seLev9hpn1uAmbPdL7lM3m691o6qawhqblOPx7olfGChAbm9IqvplIDfjzc80Hn0i0DgnG8z0142fHIi2HgktPIvD6aii0BwpkdOeNCMF0k1oacmL24ez64javkv27cyAPg1xaGprtdexlq6dDiagqsABczIKfL5uHALg2L0bbh4cwHqdCEo7vDyakpEx1jLFeJe8MOKyq3jkGrauv9loAONlHncn1gyrGv2DxObjy78yEpxifBEbex58xCilOczMy2mjlLnMHpmxl6pD0gi5FDuNKM9KBu2ijmKs0Lxj1ppxO9J\\\"},\\\"UNI_BSS_BODY\\\":{\\\"HANGON001_RSP\\\":{\\\"rspCode\\\":\\\"0000\\\",\\\"rspDesc\\\":\\\"模拟器返回成功\\\"}}}\",\"HSN_NODE_IP\":\"\",\"HSN_NODE_PORT\":0,\"HSN_PROC_LEN\":0,\"HSN_REQ_RECV_TIME\":null,\"HSN_REQ_SEND_TIME\":null,\"IS_LOG_FILE\":0,\"ODOMAIN_ID\":\"CASP\",\"OPARTY_BUSI_SEQ\":\"\",\"OPARTY_DUNS\":\"qJTRmWbwBi\",\"OPARTY_IP\":\"10.124.164.110\",\"OPARTY_REQ_TIME\":\"\",\"OPR_NAME\":\"json_jiangSU_microtest_hangon001\",\"OSN_NODE_IP\":\"10.124.164.110\",\"OSN_NODE_PORT\":8101,\"OSN_REQ_PROC_LEN\":2,\"OSN_REQ_RECV_DATA_LEN\":\"0\",\"OSN_REQ_RECV_TIME\":\"2020-11-26 15:41:01.522\",\"OSN_RSP_RECV_TIME\":\"2020-11-26 15:41:01.544\",\"PARENT_TRANS_IDC\":\"\",\"REQ_CONTENT\":\"{\\n  \\\"UNI_BSS_HEAD\\\" : {\\n    \\\"RESERVED\\\" : [ {\\n      \\\"RESERVED_VALUE\\\" : \\\"0JrGftnekpGxx\\\",\\n      \\\"RESERVED_ID\\\" : \\\"tjLkxkoHdg\\\"\\n    } ],\\n\\\"APP_ID\\\":\\\"qJTRmWbwBi\\\",\\n\\\"TIMESTAMP\\\":\\\"2020-11-04 17:53:26 938\\\",\\n\\\"TRANS_ID\\\":\\\"20201104175326938563726\\\",\\n\\\"TOKEN\\\":\\\"a4add2280db081b862a230b3ea74923a\\\"\\n  },\\n  \\\"UNI_BSS_ATTACHED\\\" : {\\n    \\\"MEDIA_INFO\\\" : \\\"kvIJdrf9gBF26bDhcLmC39EvGA4vEKs6seLev9hpn1uAmbPdL7lM3m691o6qawhqblOPx7olfGChAbm9IqvplIDfjzc80Hn0i0DgnG8z0142fHIi2HgktPIvD6aii0BwpkdOeNCMF0k1oacmL24ez64javkv27cyAPg1xaGprtdexlq6dDiagqsABczIKfL5uHALg2L0bbh4cwHqdCEo7vDyakpEx1jLFeJe8MOKyq3jkGrauv9loAONlHncn1gyrGv2DxObjy78yEpxifBEbex58xCilOczMy2mjlLnMHpmxl6pD0gi5FDuNKM9KBu2ijmKs0Lxj1ppxO9J\\\"\\n  },\\n  \\\"UNI_BSS_BODY\\\" : { }\\n}\",\"RETRY_COUNT\":\"\",\"ROUTE_TYPE1\":\"\",\"ROUTE_TYPE2\":\"\",\"ROUTE_VALUE1\":\"\",\"ROUTE_VALUE2\":\"\",\"RSP_CODE\":\"0000\",\"RSP_DESC\":\"\",\"SC_NODE_IP\":\"10.124.164.110\",\"SC_NODE_PORT\":9102,\"SC_REQ_PROC_LEN\":1,\"SC_REQ_RECV_TIME\":\"2020-11-26 15:41:01.526\",\"SC_RSP_PROC_LEN\":1,\"SC_RSP_RECV_TIME\":\"2020-11-26 15:41:01.542\",\"SERVICE_VERSION\":\"1\",\"SVC_NAME\":\"json_jiangSU_microtest_hangon001\",\"SVC_NUMBER\":1,\"TRANS_IDC\":"+uuid+",\"TRANS_IDH\":\"0a7ca46e16063764615233988da61a\",\"TRANS_IDO\":\"20201104175326938563726\",\"USER_ACCT\":\"\"}";

            System.out.println(topDataFather);
            System.out.println(topDataSon);
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
