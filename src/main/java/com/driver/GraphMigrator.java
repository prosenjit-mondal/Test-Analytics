package com.driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.common.Logger;
import com.model.BookVO;
import com.service.spec.IConnectService;
import com.service.spec.IGraphService;

@Service(value="gm")
public class GraphMigrator {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);
	@Autowired 
    private IConnectService cs;
    @Autowired
	private IGraphService gs;     
    
    public void migrateToGraph(int noThreads, int option) {

        //read from Oracle
        Iterable<BookVO> books = cs.getAllBooks();
        logger.debug("Reading of book is done...");
        int i = 0;
        //now write to neo4j each book wise
        for (BookVO book : books) {
        	cs.populateContentWithAssignment(book);
        	logger.debug("Now started writing...");
        	gs.migrateBook(book);
        	i++;        	
        }
    }
    
    public void setRealationalService(IConnectService realationalService) {
		this.cs = realationalService;
	}

	public void setGraphService(IGraphService graphService) {
		this.gs = graphService;
	}
}
