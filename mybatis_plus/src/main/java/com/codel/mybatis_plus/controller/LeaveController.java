package com.codel.mybatis_plus.controller;

import com.codel.mybatis_plus.mapper.LeaveMapper;
import com.codel.mybatis_plus.pojo.Audit;
import com.codel.mybatis_plus.pojo.Leave;
import com.codel.mybatis_plus.pojo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeaveController {
    @Autowired
    private LeaveMapper leaveMapper;


    //    请假模块
    @GetMapping("/inser/{id}")
    public RespBean test(@PathVariable(name = "id") int id) {
        Leave leave = leaveMapper.getLeave(id);
        long data = leave.getEndtime().getDate() - leave.getStarttime().getDate();
        System.out.println(data);
        leave.setLeaveDate(data);
        System.out.println(leave);
        return RespBean.ok("成功！", leave);
    }

    //插入数据
    @PostMapping("/inst")
    public RespBean testInst(@RequestBody Leave leave) {
        long data = leave.getEndtime().getDate() - leave.getStarttime().getDate();
        leave.setLeaveDate(data);
        int insertleave = leaveMapper.insertleave(leave);
        System.out.println(insertleave);
        return RespBean.ok("插入成功", insertleave);
    }

    //    查看所有公告
    @GetMapping("/getAllLeave")
    public RespBean getAllLeaves() {
        List<Leave> leaves = leaveMapper.getLeaves();

        System.out.println(leaves);
        return RespBean.ok("查找成功", leaves);

    }

    //    查找对应的请假了的请假信息
    @PostMapping("/selectLeavesByLid/{lid}")
    public RespBean selectLeavesByLid(@PathVariable(name = "lid") long lid) {
        List<Leave> leaves = leaveMapper.selectLeavesByLid(lid);
        System.out.println(leaves);
        return RespBean.ok("查找到数据", leaves);
    }

    //    管理员查看请假
    @PostMapping("/selectByUid/{uid}")
    public RespBean selectByUid(@PathVariable(name = "uid") int uid) {
        List<Leave> leaves = leaveMapper.selectByUid(uid);
        return RespBean.ok("成功", leaves);
    }

    //    管理员审核
    @PostMapping("/audit")
    public RespBean audit(@RequestBody Audit audit) {
        int state = audit.getState();
        int id = audit.getId();
        int i = leaveMapper.checkByUid(state, id);
        return RespBean.ok("成功");
    }
}
