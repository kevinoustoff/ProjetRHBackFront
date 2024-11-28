package edu.miage.springboot.seeders;

import edu.miage.springboot.dao.entities.FileEntity;
import edu.miage.springboot.dao.entities.FolderEntity;
import edu.miage.springboot.dao.repositories.FileRepository;
import edu.miage.springboot.dao.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class FolderSeeder implements CommandLineRunner {

    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private FileRepository fileRepository;

    @Override
    public void run(String... args) throws Exception {



        FolderEntity folder = new FolderEntity();
        folder.setName("Folder1");
        folder = folderRepository.save(folder);
        FileEntity file=new FileEntity();
        file.setName("File1");
        file.setFolder(folder);
        fileRepository.save(file);


    }
}
