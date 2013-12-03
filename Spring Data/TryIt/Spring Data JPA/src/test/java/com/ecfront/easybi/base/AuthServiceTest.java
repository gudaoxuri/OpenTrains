package com.ecfront.easybi.base;

import com.ecfront.easybi.BaseTest;
import com.ecfront.easybi.base.domain.*;
import com.ecfront.easybi.base.service.AuthService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import javax.inject.Inject;

public class AuthServiceTest extends BaseTest {

    private EZUser ezUser1;
    private EZUser ezUser2;
    private EZUser ezUser3;
    private EZRole ezRole1;
    private EZRole ezRole2;
    private EZResource ezResource1;
    private EZResource ezResource2;
    private EZResource ezResource3;

    @Before
    public void setup() {
        ezUser1 = new EZUser();
        ezUser1.setUserName("admin");
        ezUser1.setPassword("123");
        ezUser1.setEmail("admin@ecfront.com");
        ezUser1.setEnable(true);
        ezUser2 = new EZUser();
        ezUser2.setUserName("jzy");
        ezUser2.setPassword("123");
        ezUser2.setEmail("jzy@ecfront.com");
        ezUser2.setEnable(true);
        ezUser3 = new EZUser();
        ezUser3.setUserName("gf");
        ezUser3.setPassword("123");
        ezUser3.setEmail("gf@ecfront.com");
        ezUser3.setEnable(false);
        ezRole1 = new EZRole();
        ezRole1.setRoleName("manage");
        ezRole1.setEnable(true);
        ezRole2 = new EZRole();
        ezRole2.setRoleName("user");
        ezRole2.setEnable(true);
        ezResource1 = new EZResource();
        ezResource1.setResourceName("add user");
        ezResource1.setAction("manage/user/");
        ezResource1.setMethod(MethodType.POST);
        ezResource1.setEnable(true);
        ezResource2 = new EZResource();
        ezResource2.setResourceName("delete user");
        ezResource2.setAction("manage/user/");
        ezResource2.setMethod(MethodType.DELETE);
        ezResource2.setEnable(true);
        ezResource3 = new EZResource();
        ezResource3.setResourceName("show user");
        ezResource3.setAction("user/");
        ezResource3.setMethod(MethodType.GET);
        ezResource3.setEnable(true);

        ezRole1.addResource(ezResource1);
        ezRole1.addResource(ezResource2);
        ezRole2.addResource(ezResource3);
        ezUser1.addRole(ezRole1);
        ezUser1.addRole(ezRole2);
        ezUser2.addRole(ezRole1);
        ezUser2.addRole(ezRole2);

        authService.deleteUsers();
        authService.deleteRoles();
        authService.deleteResources();
    }

    @Test
    @Rollback(false)
    public void test() {
        authService.saveOrUpdateResource(ezResource1);
        authService.saveOrUpdateResource(ezResource2);
        authService.saveOrUpdateResource(ezResource3);
        authService.saveOrUpdateRole(ezRole1);
        authService.saveOrUpdateRole(ezRole2);
        authService.saveOrUpdateUser(ezUser1);
        authService.saveOrUpdateUser(ezUser2);
        authService.saveOrUpdateUser(ezUser3);
        EZResource resource = authService.getResource("add user");
        Assert.assertEquals(resource.getResourceName(), "add user");
        EZUser user = authService.getUser("admin", "");
        Assert.assertEquals(user.getUserName(), "admin");
        Assert.assertEquals(user.getRoles().get(1).getRoleName(), "user");
        Assert.assertEquals(user.getRoles().get(1).getResources().get(0).getResourceName(), "show user");

        ezUser1 = new EZUser();
        ezUser1.setUserName("张三");
        ezUser1.setPassword("123");
        ezUser1.setEmail("zs@ecfront.com");
        ezUser1.setEnable(true);
        authService.saveOrUpdateUser(ezUser1);
        ezUser1.addRole(ezRole1);
        authService.saveOrUpdateUser(ezUser1);
    }

    @Inject
    private AuthService authService;

}
