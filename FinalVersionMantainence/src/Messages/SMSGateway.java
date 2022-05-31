package Messages;

public class SMSGateway {
	
	 public ITaskAddedMessages taskAddedType;
	 public IGradesAnnouncemnetMessage gradesAnnouncementType;  
	 public IDailyNewsMessage dailyMsgType;
	
	 
	 
	 public String sendDailyMessage()
	 {
		 
		 return dailyMsgType.sendDailyMessage(); 
		 
	 }
	 
	 
	 public String sendTaskAdded()
	 {
		 
		 return taskAddedType.sendTaskMessage();
		 
		 
	 }
	 
	 public String sendGradesAnnouncement()
	 {
		 return gradesAnnouncementType.sendGradesAnnouncement();
		 
	 }
	 
	
	
}
