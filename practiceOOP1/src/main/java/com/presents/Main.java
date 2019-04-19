package com.presents;

import com.presents.helpers.RepositoryFiller;
import com.presents.repository.SweetPackRepository;
import com.presents.repository.SweetPackRepositoryHashSetImpl;
import com.presents.repository.SweetRepository;
import com.presents.repository.SweetRepositoryHashSetImpl;
import com.presents.service.SweetPackService;
import com.presents.service.SweetPackServiceImpl;
import com.presents.service.SweetService;
import com.presents.service.SweetServiceImpl;
import com.presents.ui.ConsoleApplication;

public class Main {
    public static void main(String[] args) {

        SweetRepository sweetRepository = new SweetRepositoryHashSetImpl();
        SweetPackRepository sweetPackRepository = new SweetPackRepositoryHashSetImpl();

        RepositoryFiller filler = new RepositoryFiller(sweetRepository, sweetPackRepository);
        filler.fill();

        SweetService sweetService = new SweetServiceImpl(sweetRepository);
        SweetPackService sweetPackService = new SweetPackServiceImpl(sweetPackRepository);

        ConsoleApplication application = new ConsoleApplication(sweetService, sweetPackService);
        application.run();
    }
}
