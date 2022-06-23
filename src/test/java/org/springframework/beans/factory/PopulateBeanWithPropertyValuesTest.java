package org.springframework.beans.factory;



import org.junit.Test;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.bean.Car;
import org.springframework.beans.factory.bean.Person;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanRefence;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author derekyi
 * @date 2020/11/24
 */
public class PopulateBeanWithPropertyValuesTest {


	@Test
	public void testPopulateBeanWithPropertyValues() throws Exception {

		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue( new PropertyValue("name", "ljq"));
		propertyValues.addPropertyValue(  new PropertyValue("age", 18));
		BeanDefinition beanDefinition = new BeanDefinition(Person.class,propertyValues);
		defaultListableBeanFactory.registerBeanDefinition("person",beanDefinition);
		Person person = (Person) defaultListableBeanFactory.getBean("person");
		assertThat(person.getName()).isEqualTo("ljq");
		assertThat(person.getAge()).isEqualTo(18);
	}


	@Test
	public void testPopulateBeanWithBean() throws Exception{
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		//注册Car实例
		PropertyValues propertyValuesForCar = new PropertyValues();
		propertyValuesForCar.addPropertyValue(new PropertyValue("brand", "porsche"));
		BeanDefinition carBeanDefinition = new BeanDefinition(Car.class, propertyValuesForCar);
		beanFactory.registerBeanDefinition("car",carBeanDefinition);

		//注册person
		PropertyValues propertyValuesForPerson = new PropertyValues();
		propertyValuesForPerson.addPropertyValue( new PropertyValue("name", "ljq"));
		propertyValuesForPerson.addPropertyValue(  new PropertyValue("age", 18));
		propertyValuesForPerson.addPropertyValue(new PropertyValue("car", new BeanRefence("car")) );
		BeanDefinition personBeanDefinition = new BeanDefinition(Person.class, propertyValuesForPerson);
		beanFactory.registerBeanDefinition("person",personBeanDefinition);
		Person person = (Person) beanFactory.getBean("person");


		assertThat(person.getName()).isEqualTo("ljq");
		assertThat(person.getAge()).isEqualTo(18);
		Car car = person.getCar();
		assertThat(car).isNotNull();
		assertThat(car.getBrand()).isEqualTo("porsche");
	}

}
