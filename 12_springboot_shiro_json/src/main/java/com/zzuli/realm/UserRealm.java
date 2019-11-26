package com.zzuli.realm;

import com.zzuli.domain.User;
import com.zzuli.service.PermissionService;
import com.zzuli.service.RoleService;
import com.zzuli.service.UserService;
import com.zzuli.utils.ActiveUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 获取当前类名
     * @return
     */
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 做认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户名
        String username = token.getPrincipal().toString();
        // 查询用户
        User user = userService.queryUserByUserName(username);
        if (user != null) {
            // 获取当前用户的角色
            List<String> roles = roleService.queryRolesByUserId(user.getUserid());
            // 获取当前角色的权限
            List<String> permissions = permissionService.queryPermissionByUserId(user.getUserid());
            // 封装ActiveUser
            ActiveUser activeUser = new ActiveUser(user, roles, permissions);
            // 盐 用户名+地址作为盐
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername() + user.getAddress());

            // 封装认证信息并返回
            return new SimpleAuthenticationInfo(activeUser, user.getUserpwd(), credentialsSalt, this.getName());
        } else {
            return null;
        }
    }

    /**
     * 做授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取主身份信息
        ActiveUser activeUser = (ActiveUser) principals.getPrimaryPrincipal();
        // 授权信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取角色和权限
        List<String> roles = activeUser.getRoles();
        List<String> permissions = activeUser.getPermissions();
        // 判空
        if (roles != null && roles.size() > 0) {
            info.addRoles(roles);
        }
        if (permissions != null && permissions.size() > 0) {
            info.addStringPermissions(permissions);
        }

        return info;
    }


}
