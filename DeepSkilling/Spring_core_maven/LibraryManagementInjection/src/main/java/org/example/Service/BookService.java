package org.example.Service;

import org.example.Repository.BookRepository;

public class BookService {
    private BookRepository setterRepository;
    private BookRepository constructorRepository;

    public BookService(BookRepository constructorRepository)
    {
        this.constructorRepository = constructorRepository;
    }
    public void setSetterRepository(BookRepository setterRepository) {
        this.setterRepository = setterRepository;
    }

    public void addBook(){
        System.out.println("Constructor Injection:");

        constructorRepository.saveBook();

        System.out.println();

        System.out.println("Setter Injection:");

        setterRepository.saveBook();

    }
}
