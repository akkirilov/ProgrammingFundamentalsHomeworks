package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.models.Author;
import app.repositories.AuthorRepository;
import app.services.api.AuthorService;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public void save(Author author) {
		authorRepository.save(author);
	}

	@Override
	public void save(List<Author> authors) {
		authorRepository.save(authors);
	}

	@Override
	public List<Author> findByReleaseDateOfBookBeforeYear(int year) {
		return authorRepository.findByReleaseDateOfBookBeforeYear(year);
	}

	@Override
	public List<Author> findAllAndOrderByBooksCount() {
		return authorRepository.findAllAndOrderByBooksCount();
	}

	@Override
	public List<Author> findAllByFirstNameEndsWith(String suffix) {
		return authorRepository.findAllByFirstNameEndsWith(suffix);
	}

	@Override
	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	@Override
	public Integer getTotalCopiesOfBooks(Long id) {
		return authorRepository.getTotalCopiesOfBooks(id);
	}

	@Override
	public Integer getTotalBooks(String firstName, String lastName) {
		return authorRepository.getTotalBooks(firstName, lastName);
	}

}
