/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.spring.test.taskassignment;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.test.PvmTestCase;
import org.activiti.engine.impl.util.CollectionUtil;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author Joram Barrez
 */
public class CustomTaskAssignmentTest extends PvmTestCase {
  
  public void testSetAssigneeThroughSpringService() {
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("org/activiti/spring/test/taskassignment/taskassignment-context.xml");
    RuntimeService runtimeService = (RuntimeService) applicationContext.getBean(RuntimeService.class);
    TaskService taskService = (TaskService) applicationContext.getBean(TaskService.class);
    
    runtimeService.startProcessInstanceByKey("assigneeThroughSpringService", CollectionUtil.singletonMap("emp", "fozzie"));
    assertEquals(1, taskService.createTaskQuery().taskAssignee("Kermit The Frog").count());
  }

}
