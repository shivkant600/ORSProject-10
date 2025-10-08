
package com.rays.ctl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.MarksheetDTO;
import com.rays.form.MarksheetForm;
import com.rays.service.MarksheetServiceInt;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@RestController
@RequestMapping(value = "Jasper")
public class JasperCtl extends BaseCtl<MarksheetForm, MarksheetDTO, MarksheetServiceInt> {

//	  @Autowired 
	private SessionFactory sessionFactory = null;

	@Autowired
	ServletContext context;

	@PersistenceContext
	protected EntityManager entityManager;

	@GetMapping(value = "report", produces = { MediaType.APPLICATION_JSON_VALUE })
	public void display(HttpServletRequest request, HttpServletResponse response)
			throws JRException, SQLException, IOException {

		ORSResponse res = new ORSResponse(true);

		ResourceBundle rb = ResourceBundle.getBundle("application");

		String path = context.getRealPath(rb.getString("jasper"));

		Connection con = null;

		JasperReport jasperReport = JasperCompileManager.compileReport(rb.getString("jasper"));

		Map<String, Object> map = new HashMap<String, Object>();

		this.sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
		con = sessionFactory.getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class)
				.getConnection();

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, con);

		byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

		response.setContentType("application/pdf");
		response.getOutputStream().write(pdf);
		response.getOutputStream().flush();
	}

}