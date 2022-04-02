package com.github.zhangchunsheng.authentication.bean.request;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zhangchunsheng.mangix.common.bean.request.BaseMangixRequest;
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
public class LoginUrlRequest extends BaseMangixRequest {
    private static final long serialVersionUID = -7083914585539687741L;

    @SerializedName("username")
    private String username;

    @SerializedName("next")
    private String next;

    public static LoginUrlRequest fromJson(String json) {
        return MangixGsonBuilder.create().fromJson(json, LoginUrlRequest.class);
    }

    @Override
    public String toString() {
        return MangixGsonBuilder.create().toJson(this);
    }

}
