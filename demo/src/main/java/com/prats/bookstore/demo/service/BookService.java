package com.prats.bookstore.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prats.bookstore.demo.json.BookJson;
import com.prats.bookstore.demo.model.Book;
import com.prats.bookstore.demo.model.BookView;
import com.prats.bookstore.demo.model.User;
import com.prats.bookstore.demo.repository.IBookRepository;
import com.prats.bookstore.demo.repository.IBookViewRepository;
import com.prats.bookstore.demo.repository.IUserRepository;

@Service
public class BookService {

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IBookRepository bookRepository;
	@Autowired
	private IBookViewRepository bookViewRepository;

	public BookJson handleGetBookByIdRequest(String id) {
		Book book = bookRepository.getOne(id);
		List<Book> relevantBooks = getBooksOrderedBySimilarity(book);
		BookJson bookJson = new BookJson(book, relevantBooks);
		return bookJson;
	}

	public List<Book> handleGetAllBooksRequest() {
		List<Book> books = bookRepository.findAll();
		return books;
	}

	List<Book> getBooksOrderedBySimilarity(Book book) {
		List<Book> relevantBooks = new ArrayList<Book>();
		Map<Book, Double> sortedMap = formCosineSimilarityMap(book);
		for (Map.Entry<Book, Double> entry : sortedMap.entrySet()) {
			relevantBooks.add(entry.getKey());
		}
		return relevantBooks;
	}

	/**
	 * This method forms a sorted Map of Books according the Cosine Similarity with
	 * the provided Book.
	 * 
	 * @param book
	 * @return Map<Book, Double>
	 */
	Map<Book, Double> formCosineSimilarityMap(Book book) {
		Map<Book, Double> sortedMap = new HashMap<Book, Double>();
		List<BookView> bookViews = bookViewRepository.findAll();
		Map<String, List<Integer>> matrix = getMapForSimilarityCalculation(bookViews);
		List<Integer> vector1 = matrix.get(book.getId());
		for (Map.Entry<String, List<Integer>> entry : matrix.entrySet()) {
			// we do not want to compare the same vector twice
			if (!entry.getKey().equals(book.getId())) {
				List<Integer> vector2 = entry.getValue();
				double similarity = UtilityService.getCosineSimilarity(vector1, vector2);
				sortedMap.put(bookRepository.getOne(entry.getKey()), similarity);
			}
		}

		return sortedMap.entrySet().stream().sorted((Map.Entry.<Book, Double>comparingByValue().reversed()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	/**
	 * This method forms the matrix in the form a Map which helps in the Cosine
	 * Similarity calculation. The key of the Map represents the book id and the
	 * value represents the vector which contains either 1 if the user has viewed it
	 * or 0 otherwise.
	 * 
	 * @param bookViews
	 * @return Map<String, List<Integer>>
	 */
	Map<String, List<Integer>> getMapForSimilarityCalculation(List<BookView> bookViews) {
		Map<String, List<Integer>> matrix = null;

		if (null != bookViews || !bookViews.isEmpty()) {
			matrix = new HashMap<>();

			// find how many Users are available in the database
			List<User> users = userRepository.findAll();
			// group the Books according to the bookId from the BookView table
			Map<String, List<BookView>> groupedByBookIdMap = bookViews.stream()
					.collect(Collectors.groupingBy(BookView::getBookId));
			for (Map.Entry<String, List<BookView>> entry : groupedByBookIdMap.entrySet()) {
				List<Integer> vector = new ArrayList<>(); // book vector
				List<BookView> bookViewList = entry.getValue();
				for (User user : users) {
					// if user has viewed the book then we enter 1 or else 0
					BookView viewedBook = bookViewList.stream()
							.filter(bookView -> bookView.getUsername().equals(user.getUsername())).findFirst()
							.orElse(null);
					if (null != viewedBook)
						vector.add(1);
					else
						vector.add(0);
				}
				matrix.put(entry.getKey(), vector);
			}
		}

		return matrix;
	}

}
