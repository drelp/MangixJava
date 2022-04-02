package me.zhangchunsheng.mangix.common.exception;

import com.google.common.base.Joiner;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zhangchunsheng.mangix.common.bean.result.BaseMangixResult;

/**
 * <pre>
 * JumpServer异常结果类
 * Created by Chunsheng Zhang on 2020-4-20.
 * </pre>
 *
 * @author ChunshengZhang
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MangixException extends Exception {
    private static final long serialVersionUID = 2214381471513460742L;

    /**
     * 自定义错误讯息.
     */
    private String customErrorMsg;
    /**
     * 返回状态码.
     */
    private int retCode;
    /**
     * 返回信息.
     */
    private String message;

    /**
     * 业务结果.
     */
    private String code;

    /**
     * Instantiates a new Mangix exception.
     *
     * @param customErrorMsg the custom error msg
     */
    public MangixException(String customErrorMsg) {
        super(customErrorMsg);
        this.customErrorMsg = customErrorMsg;
    }

    /**
     * Instantiates a new Mangix exception.
     *
     * @param customErrorMsg the custom error msg
     * @param tr             the tr
     */
    public MangixException(String customErrorMsg, Throwable tr) {
        super(customErrorMsg, tr);
        this.customErrorMsg = customErrorMsg;
    }

    private MangixException(Builder builder) {
        super(builder.buildErrorMsg());
        retCode = builder.retCode;
        message = builder.message;
        code = builder.code;
    }

    /**
     * 通过BaseMangixResult生成异常对象.
     *
     * @param baseResult the base result
     * @return the jumpserver exception
     */
    public static MangixException from(BaseMangixResult baseResult) {
        return MangixException.newBuilder()
                .retCode(baseResult.getRetCode())
                .message(baseResult.getMessage())
                .code(baseResult.getCode())
                .build();
    }

    /**
     * New builder builder.
     *
     * @return the builder
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The type Builder.
     */
    public static final class Builder {
        private int retCode;
        private String message;
        private String code;

        private Builder() {
        }

        /**
         * Return status builder.
         *
         * @param retCode the return status
         * @return the builder
         */
        public Builder retCode(int retCode) {
            this.retCode = retCode;
            return this;
        }

        /**
         * Return info builder.
         *
         * @param message the return info
         * @return the builder
         */
        public Builder message(String message) {
            this.message = message;
            return this;
        }

        /**
         * Result code builder.
         *
         * @param code the result code
         * @return the builder
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * Build jumpserver exception.
         *
         * @return the jumpserver exception
         */
        public MangixException build() {
            return new MangixException(this);
        }

        /**
         * Build error msg string.
         *
         * @return the string
         */
        public String buildErrorMsg() {
            return Joiner.on("，").skipNulls().join(
                    String.format("返回代码：[%s]", retCode),
                    message == null ? null : String.format("返回信息：[%s]", message),
                    code == null ? null : String.format("结果代码：[%s]", code)
            );
        }
    }
}
