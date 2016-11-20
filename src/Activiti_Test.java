import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.apache.coyote.http11.filters.VoidInputFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class Activiti_Test {
	
	@Autowired
	ProcessEngineFactoryBean processEngine;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private HistoryService historyService;
	
	@Test
	public void test(){
		//部署流程定义
//		Deployment deploy = repositoryService.createDeployment().name("请假").addClasspathResource("leaveProcess.bpmn").addClasspathResource("leaveProcess.png").deploy();
//		
//		System.out.println("部署id"+deploy.getId());
		//创建流程实例
//		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");
//		
//		System.out.println("流程实例ID"+processInstance.getId());
//		
//		System.out.println("流程定义ID"+processInstance.getProcessDefinitionId());
		//获取流程实例的task（节点）
//		Task singleResult = taskService.createTaskQuery().taskName("审核").orderByTaskCreateTime().asc().singleResult();
		
//		System.out.println(singleResult.getName());
//		//存储流程变量
//		taskService.setVariable(singleResult.getId(), "lyc", "sb");
		//获取流程实例中的变量
//		Object variable = taskService.getVariable(singleResult.getId(), "lyc");
		
//		System.out.println(variable);
		//指定流程实例的代理人（可重复被他人认领）
//		singleResult.setAssignee("张三");
		//指定流程实例的代理人（但是谁手快是谁的）
//		taskService.claim(singleResult.getId(), "李四");
		//完成task
//		taskService.complete(singleResult.getId());
		//删除流程定义（第二个参数为true，级联删除所有有关流程定义的数据）
//		repositoryService.deleteDeployment("160001", true);
		//根据流程实例的id获取流程实例本身
		ProcessInstance singleResult = runtimeService.createProcessInstanceQuery().processInstanceId("262501").singleResult();
		//判断流程是否结束，如果为空代表当前任务已完成
		if(singleResult==null){
			System.out.println();
		}
		
	}

}
