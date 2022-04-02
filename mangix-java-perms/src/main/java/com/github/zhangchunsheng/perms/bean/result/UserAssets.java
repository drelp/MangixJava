package com.github.zhangchunsheng.perms.bean.result;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zhangchunsheng.mangix.common.bean.result.BaseMangixResult;
import me.zhangchunsheng.mangix.common.util.json.MangixGsonBuilder;

import java.util.List;

/**
 * <pre>
 * 结果对象类
 * Created by Chunsheng Zhang on 2022/4/2.
 * {
 *       "id": "f4fc0c19-e194-422e-a90a-7779c5aa9269",
 *       "hostname": "",
 *       "ip": "",
 *       "protocols": [
 *         "ssh/2222"
 *       ],
 *       "os": null,
 *
 *       "domain": null,
 *       "platform": "Linux",
 *       "comment": "",
 *       "org_id": "00000000-0000-0000-0000-000000000002",
 *       "is_active": true,
 *       "org_name": "Default"
 *     }
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserAssets extends BaseMangixResult {
    private static final long serialVersionUID = -1083910585539687746L;

    private String id;
    private String hostname;
    private String ip;
    private List<String> protocols;
    private String os;

    private String domain;
    private String platform;
    private String comment;
    private String org_id;
    private String is_active;
    private String org_name;

    public static UserAssets fromJson(String json) {
        return MangixGsonBuilder.create().fromJson(json, UserAssets.class);
    }

    @Override
    public String toString() {
        return MangixGsonBuilder.create().toJson(this);
    }

}
