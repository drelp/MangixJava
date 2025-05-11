# MangixJava
API Java SDK

### 使用SDK
```java
// spring boot, inject authenticationService, maybe deny
LoginUrlResult result = this.authenticationService.getLoginUrl("test", "/luna/");

UserAssetsResult result = this.userAssetsServiceImpl.getUserAssets(0, 15, 1, 1);
```

### maven
### Maven 引用方式
```xml
<dependencies>
    <dependency>
        <groupId>com.github.zhangchunsheng</groupId>
        <artifactId>mangix-java-authentication</artifactId>
        <version>1.0.1</version>
    </dependency>
    
    <dependency>
        <groupId>com.github.zhangchunsheng</groupId>
        <artifactId>mangix-java-perms</artifactId>
        <version>1.0.1</version>
    </dependency>
</dependencies>
```

### authentication sso
```json
{
  "login_url":"https://domain/api/v1/authentication/sso/login/?authkey=136ae172-01d9-4d08-8ed3-e8292420665f&next=%2Fluna%2F"
}
```

### perms users assets
```json
{
  "count": 1,
  "next": null,
  "previous": null,
  "results": [
    {
      "id": "f4fc0c19-e194-422e-a90a-7779c5aa9269",
      "hostname": "",
      "ip": "",
      "protocols": [
        "ssh/2222"
      ],
      "os": null,
      "domain": null,
      "platform": "Linux",
      "comment": "",
      "org_id": "00000000-0000-0000-0000-000000000002",
      "is_active": true,
      "org_name": "Default"
    }
  ]
}
```

<table border="0">
	<tbody>
		<tr>
			<td align="center" valign="middle">
				<a href="https://url.cn/5jVTRwI" target="_blank">
					<!--<img height="120" src="https://wx4.sinaimg.cn/mw690/46b94231ly1ge0pvo2necj209l05kq3c.jpg">-->
					<img height="120" src="https://aigc.7otech.com/wp-content/uploads/2025/05/tencent.jpeg">
				</a>
			</td>
			<td align="right" valign="middle">
				<!--<img height="120" src="https://wx2.sinaimg.cn/mw690/46b94231ly1ge0po9ko70j20fk0fkjsc.jpg">-->
				<img height="120" src="https://aigc.7otech.com/wp-content/uploads/2025/05/fenxiang.jpeg">
			</td>
			<td align="center" valign="middle">
				<a href="https://www.vultr.com/?ref=8546025-6G" target="_blank">
					<!--<img height="120" src="https://wx3.sinaimg.cn/mw1024/46b94231ly1ge0p76k64bj206o06owev.jpg">-->
					<img height="120" src="https://aigc.7otech.com/wp-content/uploads/2025/05/vultr.jpeg">
				</a>
			</td>
			<td align="center" valign="middle">
				<a href="https://www.aliyun.com/minisite/goods?userCode=tewwu0c8" target="_blank">
					<!--<img height="120" src="https://img.alicdn.com/tfs/TB1Gc3zmAL0gK0jSZFxXXXWHVXa-259-194.jpg">-->
					<img height="120" src="https://aigc.7otech.com/wp-content/uploads/2025/05/aliyun.jpeg">
				</a>
			</td>
		</tr>
	</tbody>
</table>

## 捐助 donate

<table border="0">
	<tbody>
	    <tr>
	        <td>支付宝</td>
	        <td>微信</td>
	    </tr>
		<tr>
			<td align="left" valign="middle">
                <!--<img height="120" src="https://wx4.sinaimg.cn/mw690/46b94231ly1ge0okee0fej20ec0e6gp3.jpg">-->
                <img height="120" src="https://aigc.7otech.com/wp-content/uploads/2025/05/alipay.jpeg">
			</td>
			<td align="center" valign="middle">
				<!--<img height="120" src="https://wx4.sinaimg.cn/mw690/46b94231ly1ge0okecldyj20e80e8n0c.jpg">-->
				<img height="120" src="https://aigc.7otech.com/wp-content/uploads/2025/05/wechat.jpeg">
			</td>
		</tr>
	</tbody>
</table>
