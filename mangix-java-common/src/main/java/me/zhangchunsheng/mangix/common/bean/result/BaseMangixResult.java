package me.zhangchunsheng.mangix.common.bean.result;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;
import me.zhangchunsheng.mangix.common.util.json.MangixGsonBuilder;
import org.apache.commons.lang3.StringUtils;

import lombok.Data;

/**
 * <pre>
 * JumpServer结果共用属性类.
 * Created by Chunsheng Zhang on 2022/4/2.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Data
public abstract class BaseMangixResult implements Serializable {
    private static final long serialVersionUID = 2101652152604850904L;
    private static final Integer OK = 200;
    protected String message;
    @SerializedName("code")
    protected String code;
    protected int retCode = OK;

    /**
     * 请求是否成功.
     */
    public boolean isSuccess() {
        return retCode == 200;
    }

    public static BaseMangixResult fromJson(String json) {
        return MangixGsonBuilder.create().fromJson(json, BaseMangixResult.class);
    }

    @Override
    public String toString() {
        return MangixGsonBuilder.create().toJson(this);
    }
}
