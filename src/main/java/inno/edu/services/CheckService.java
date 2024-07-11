package inno.edu.services;

import inno.edu.check.AbstractCheck;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Getter
public class CheckService {
    @Autowired
    List<AbstractCheck> abstractChecks;
}

