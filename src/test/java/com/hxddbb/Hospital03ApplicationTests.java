//package com.hxddbb;
//
//import com.hxddbb.common.OptionUtils;
//import com.hxddbb.dao.lbdoctorMapper;
//import com.hxddbb.dao.lboptionMapper;
//import com.hxddbb.dao.lbseekMapper;
//import com.hxddbb.entity.lbseek;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.annotation.Resource;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootTest
//class Hospital03ApplicationTests {
//    @Resource
//    private lbdoctorMapper ldoc;
//    @Resource
//    private lboptionMapper optiondao;
//    @Resource
//    private lbseekMapper seekdao;
//    @Test
//    void contextLoads() {
//
////        QueryWrapper<lbdoctor> query = new QueryWrapper<>();
//////        query.lambda().eq(lbdoctor::getCertId,"23123124124");
////        ldoc.selectOne(query);
//        ldoc.selectByPrimaryKey("213123123");
//
//    }
//    @Test
//    void testprice() {
//        List<Integer> ids= new ArrayList<Integer>();
//        ids.add(1);
//
//        lbseek seek=new lbseek();
//        seek.setPrice(optiondao.getTotalPrice(ids));
//        System.out.println("--------->"+seek.getPrice());
//
//    }
//    @Test
//    void testinsertprice(){
//        lbseek seek=new lbseek();
//        BigDecimal  xgprice= optiondao.getTotalPrice(OptionUtils.getOptionIds(seek.getOptions()));
//
//        seek.setPrice(xgprice);
//        System.out.println("--------->"+seek.getPrice());
//    }
//}
