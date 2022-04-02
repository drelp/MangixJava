package com.github.zhangchunsheng.perms.service;

import com.github.zhangchunsheng.perms.bean.result.UserAssetsResult;
import me.zhangchunsheng.mangix.common.exception.MangixException;
import me.zhangchunsheng.mangix.common.service.MangixService;

/**
 * <pre>
 * 手机归属地API
 * Created by Chunsheng Zhang on 2022/4/2.
 *
 * https://domain/api/v1/authentication/sso/login-url/
 *
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public interface UserAssetsService extends MangixService {

    /**
     * https://domain/api/v1/perms/users/assets/?offset=0&limit=15&display=1&draw=1
     * @param offset
     * @param limit
     * @param display
     * @param draw
     * @return
     * @throws MangixException
     */
    public UserAssetsResult getUserAssets(Integer offset, Integer limit, Integer display, Integer draw) throws MangixException;

}
