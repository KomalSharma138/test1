package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			 new Topic("1" , "java" , "java topics"),
			 new Topic("2" , "spring" , "spring topics"),
			 new Topic("3" , "spring boot" , "spring boot topics")
			));
	
	public List<Topic> getAlTopics()
	{
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
   
	public void addTopic(Topic topic)
	{
		topics.add(topic);
	}
	
	public void updateTopic(Topic topic,String id)
	{
		for(int i=0;i<topics.size();i++)
		{
			Topic t = topics.get(i);
			if(t.getId().equals(id))
			{
			 topics.set(i, topic);
			}
		}
	}
	
	public void deleteTopic(String id)
	{
		/*for(int i=0;i<topics.size();i++)
		{
			Topic t = topics.get(i);
			if(t.getId().equals(id))
			{
				topics.remove(t);
			}
		}*/
		
		topics.removeIf(t -> t.getId().equals(id));
		
		
	}
}
