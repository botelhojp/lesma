package lesma.model.direct.run;

import lesma.annotations.StartSMA;
import lesma.model.direct.agent.TaskAgent;

import org.apache.log4j.Logger;
import org.jfree.ui.about.ProjectInfo;

@StartSMA(
		trustmodel = "Direct Model - d001 - v1.0", 
		agents = { TaskAgent.class }
)
public class Direct001 {

	protected static Logger log = Logger.getLogger(Direct001.class);

	public static void main(String[] args) {
		try {
			if (args != null && args.length > 0) {
				openjade.Boot.main(args);
			} else {
				openjade.Boot.loadXml();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
