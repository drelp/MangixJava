package com.github.zhangchunsheng.perms.service.impl;

import com.github.zhangchunsheng.perms.bean.result.UserAssetsResult;
import com.github.zhangchunsheng.perms.service.UserAssetsService;
import me.zhangchunsheng.mangix.common.constant.MangixConstants;
import me.zhangchunsheng.mangix.common.exception.MangixException;
import me.zhangchunsheng.mangix.common.service.impl.MangixServiceApacheHttpImpl;

/**
 * <pre>
 * JumpServer接口请求实现类，默认使用Apache HttpClient实现
 * Created by Chunsheng Zhang on 2022/4/2.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public class UserAssetsServiceImpl extends MangixServiceApacheHttpImpl implements UserAssetsService {
    @Override
    public UserAssetsResult getUserAssets(Integer offset, Integer limit, Integer display, Integer draw) throws MangixException {
        String responseContent = this.getJson(String.format(this.getConfig().getBaseUrl() + MangixConstants.Url.PERMS_USERS_ASSETS_URL, offset, limit, display, draw), this.getConfig().getPrivateToken());
        return UserAssetsResult.fromJson(responseContent);
    }
}
