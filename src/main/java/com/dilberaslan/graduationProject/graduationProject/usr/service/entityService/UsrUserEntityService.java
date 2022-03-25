package com.dilberaslan.graduationProject.graduationProject.usr.service.entityService;

import com.dilberaslan.graduationProject.graduationProject.gen.exceptions.AlreadyExistException;
import com.dilberaslan.graduationProject.graduationProject.gen.service.BaseEntityService;
import com.dilberaslan.graduationProject.graduationProject.usr.dao.UsrUserDao;
import com.dilberaslan.graduationProject.graduationProject.usr.entity.UsrUser;
import com.dilberaslan.graduationProject.graduationProject.usr.enums.UsrErrorMessage;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Dilber
 */
@Service
public class UsrUserEntityService extends BaseEntityService<UsrUser, UsrUserDao> {
    public UsrUserEntityService(UsrUserDao dao) {
        super(dao);
    }


    public UsrUser saveWithControl(UsrUser usrUser) {
        boolean isUserNameExist;
        isUserNameExist = getDao().existsByUserName(usrUser.getUserName());
        if (isUserNameExist) {
            throw new AlreadyExistException(UsrErrorMessage.USER_ALREADY_IS_EXIST);
        }
        usrUser = save(usrUser);
        return usrUser;
    }


    public Optional<UsrUser> findByUserName(String username) {
        return getDao().findByUserName(username);
    }

}
