package service;

import dao.PcdDao;
import domain.PCD;
import flexjson.JSONSerializer;

import java.util.List;

public class PcdService {
    public String findALLPcd(int pid) {
        PcdDao pd = new PcdDao();

        List<PCD> list = pd.findAllPcd(pid);
        return new JSONSerializer().exclude("*.class").serialize(list);
    }
}
