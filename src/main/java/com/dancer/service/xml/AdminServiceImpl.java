package com.dancer.service.xml;

import com.dancer.dao.mapper.TAdminMapper;
import com.dancer.entity.TAdmin;
import com.dancer.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private TAdminMapper adminMapper;
    @Override
    public int insertAdmin(TAdmin admin) {
        return adminMapper.insert(admin);
    }

    @Override
    public int deleteAdmin(int adminId) {
        return adminMapper.deleteByPrimaryKey(adminId);
    }

    @Override
    public int updateAdmin(TAdmin admin) {
        return adminMapper.updateByPrimaryKey(admin);
    }

    @Override
    public TAdmin getAdminById(int adminId) {
        return adminMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public List<TAdmin> getAllAdmin() {
        return adminMapper.selectAllAdmin();
    }

    @Override
    public TAdmin getByName(String name) {
        return adminMapper.selectByName(name);
    }

}
