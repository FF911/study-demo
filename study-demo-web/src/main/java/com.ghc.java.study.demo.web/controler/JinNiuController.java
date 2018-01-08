/*
package com.ghc.java.study.demo.web.controler;

import com.le.jr.fund.data.common.diamond.RsaPriKeyHelper;
import com.le.jr.fund.data.service.jinniu.JinNiuService;
import com.le.jr.platform.utils.security.MD5Utils;
import com.le.jr.platform.utils.security.RSAUtils;
import com.le.jr.trade.publictools.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.Map;

*/
/**
 * Created by yangbo on 2017/5/22.
 *//*

@Controller
@RequestMapping({"api/fund/jinniu"})
public class JinNiuController {
    private static final Logger log = LoggerFactory.getLogger(JinNiuController.class);
    private int BYTE_SIZE = 10 * 1024 * 1024;
    @Resource
    private RsaPriKeyHelper rsaPriKeyHelper;
    @Resource
    private JinNiuService jinNiuService;

    @ResponseBody
    @RequestMapping(value = "/pushData", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public String pushData(HttpServletRequest request) {
        log.info("FundDataImport JinNiuController.pushData method start ...");
        log.info("FundDataImport sign=" + request.getHeader("sign"));
        log.info("FundDataImport table=" + request.getHeader("table"));
        String sign = request.getHeader("sign");
        String table = request.getHeader("table");
        if (StringUtil.isBlank(sign) || StringUtil.isBlank(table)) {
            return "error";
        }
        try {
            ServletInputStream sis = request.getInputStream();
            int len = 0;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[BYTE_SIZE];
            while ((len = sis.read(b)) > 0) {
                bos.write(b, 0, len);
            }
            String bodyData = new String(bos.toByteArray(), "GBK");
            Map<Object, Object> map = rsaPriKeyHelper.getMessage("priKey");
            String privateKey = (String) map.get("privateKey");
            //String privateKey="MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAJ6efdNt/8dnZ2NpF7zCAfniHlF6ndBzrxzSsS6YLgu8OA4Xey2ZoSw+RN+8+JtZ5RG8H57qDJwDKRbeJTiUSijpIa98cW0jmTr+r3Ug0yQ+E07DHUTZZuranevxkSTIa6kOHOyxh2/MkPflpUc4yzI06YHAe0Ss1vepRbOSKHJtAgMBAAECgYEAjvqoyyQVcuZXwLljp0duRpQ35hRUGymcSKv3ANw2bWedU76Az0rziJEcvl1173spzEG6cyHgeeUzbaSTApxQ94I6bK8GJVE4c/QmeG/J0idEx1y9M7ebDiZ0RAX6111E5KppFQBTQptqhV/EJqkzNBsj0n7BEEcrRaipHQ0N5WECQQDPClBilCM07qm+iPfldEwCZkVGBh9C9dasHsyQFt09uRIbJpkvb3KuFMJ7Kmnsl1J0MCxP6iIzS72V9QoqLeCFAkEAxCDiQ8Lcnmpo17hvCMn/rQ6njeA30uG09t2vgtU/CxoHq4sWmFhPkJkXmJcVCaHkFbZd7S6m6Lm1XPNR6IOiyQJBAMWTVSTNs09XFjuSn+ai9cowaJkrTHfs/KCif5pdh2HYlBO+4N5on2rKutEop4601WW1dwQILfz/oXtSLRIVV7UCQCSFqxzLMKIfVp61LZgJZZ8oV3NICZ0vgq9l4MUQSMkcc8kyAWclKsvWdlpn5/b/OqYAa8U7JsG3s1o3xUzzFmECQQCTGaGFuFrS4GvyYHZ41SpBjSBRBoyjpU55VURk1ICsjtAKsZprHHsK3BbITVptzT/xJEvMOS4mosDcyExBYFu+";
            String decParam = RSAUtils.decryptByPrivateKey(bodyData, Charset.forName("GBK"), privateKey);
            log.info("FundDataImport 解密后的数据:" + decParam);
            if (!sign.equals(MD5Utils.getMD5(decParam).toUpperCase())) {
                log.info("FundDataImport 签名table=" + request.getHeader("table")+" 传来的签名sign:" + sign);
                log.info("FundDataImport 签名table=" + request.getHeader("table")+" 计算后的签名sign:" + MD5Utils.getMD5(decParam));
                return "error";
            }
            log.info("FundDataImport >>>>>>>验签通过,数据正常");
            jinNiuService.parseFundDataJson(decParam, table);
        } catch (Exception e) {
            log.error("FundDataImport 接收金牛数据异常", e);
            return "error";
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/test")
    public String getTest() {

        log.info("调用test=========================================");
        return "sucess";
    }
}*/
