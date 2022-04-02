package com.github.zhangchunsheng.authentication.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zhangchunsheng.mangix.common.bean.result.BaseMangixResult;
import me.zhangchunsheng.mangix.common.util.json.MangixGsonBuilder;

/**
 * <pre>
 * 结果对象类
 * Created by Chunsheng Zhang on 2022/4/2.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LoginUrlResult extends BaseMangixResult {
    private static final long serialVersionUID = -7083914585539687746L;

    @SerializedName("login_url")
    private String loginUrl;

    public static LoginUrlResult fromJson(String json) {
        return MangixGsonBuilder.create().fromJson(json, LoginUrlResult.class);
    }

    @Override
    public String toString() {
        return MangixGsonBuilder.create().toJson(this);
    }

}
