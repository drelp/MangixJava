package com.github.zhangchunsheng.perms.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zhangchunsheng.mangix.common.bean.result.BaseMangixResult;
import me.zhangchunsheng.mangix.common.util.json.MangixGsonBuilder;

import java.util.List;

/**
 * <pre>
 * 结果对象类
 * Created by Chunsheng Zhang on 2022/4/2.
 *
 * {
 *   "count": 1,
 *   "next": null,
 *   "previous": null,
 *   "results": [
 *     {
 *       "id": "f4fc0c19-e194-422e-a90a-7779c5aa9269",
 *       "hostname": "",
 *       "ip": "",
 *       "protocols": [
 *         "ssh/2222"
 *       ],
 *       "os": null,
 *       "domain": null,
 *       "platform": "Linux",
 *       "comment": "",
 *       "org_id": "00000000-0000-0000-0000-000000000002",
 *       "is_active": true,
 *       "org_name": "Default"
 *     }
 *   ]
 * }
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserAssetsResult extends BaseMangixResult {
    private static final long serialVersionUID = -183914585539687746L;

    @SerializedName("count")
    private Integer count;
    private Integer next;
    private Integer previous;
    private List<UserAssets> results;

    public static UserAssetsResult fromJson(String json) {
        return MangixGsonBuilder.create().fromJson(json, UserAssetsResult.class);
    }

    @Override
    public String toString() {
        return MangixGsonBuilder.create().toJson(this);
    }

}
