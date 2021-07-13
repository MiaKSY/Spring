package exercise.order.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import exercise.order.domain.Customer;
import exercise.order.repository.CustomerRepository;
import exercise.order.repository.CustomerRepositoryImpl;

@Component // 객체 생성의 신호
public class CustomerServiceImpl implements CustomerService {

	@Autowired // 주입시키라는 신호
	private CustomerRepository repository;
	


	@Override
	public void saveCustomer(Customer customer) {
		repository.save(customer);
	}


	@Override
	public void deleteCustomer(long id) {
		repository.delete(id);
	}
}
