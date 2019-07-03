package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	

	
	public List<Course> getAlCourses(String topicId)
	{
		//return topics;
		List<Course> corurses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(corurses::add);
		return corurses;
	}
	
	public Course getCourse(String id)
	{
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id).get();
	}
   
	public void addTopic(Course topic)
	{
		courseRepository.save(topic);   
	}
	
	public void updateCourse(Course course)
	{
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id)
	{
		
		//topics.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
		
	}
}
