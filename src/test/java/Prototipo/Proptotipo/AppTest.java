package Prototipo.Proptotipo;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.home.model.Categoria;
import fr.home.model.Encuesta;
import fr.home.model.Pregunta;
import fr.home.model.Respuesta;
import fr.home.model.SesionEncuesta;
import fr.home.model.Version;
import fr.home.service.ICategoriaService;
import fr.home.service.IEncuestaService;
import fr.home.service.IPreguntaService;
import fr.home.service.IRespuestaService;
import fr.home.service.ISesionEncuestaService;
import fr.home.service.IVersionService;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
	private ClassPathXmlApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		this.context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
	}
	
	@Test
	public void Test() {
		try {
			//// Categoria: Add and getAll
			ICategoriaService catService = (ICategoriaService) context.getBean("categoriaService");
			List<Categoria> cat1 = (List<Categoria>) catService.getAll();
			
			Categoria c1 = new Categoria("Salud", 2);
			Categoria c2 = new Categoria("Vivienda", 3);
			
			catService.add(c1);
			catService.add(c2);
			
			List<Categoria> cat2 = (List<Categoria>) catService.getAll();
			
			assertTrue(cat2.size() == cat1.size() + 2);
			
			//// Encuesta: Add and getAll
			IEncuestaService encService = (IEncuestaService) context.getBean("encuestaService");
			List<Encuesta> enc1 = (List<Encuesta>) encService.getAll();
			
			encService.add(new Encuesta("Poligono A8", "002", false));
			
			List<Encuesta> enc2 = (List<Encuesta>) encService.getAll();
			
			assertTrue(enc2.size() == enc1.size() + 1);
			
			//// Pregunta: Add and getAll
			IPreguntaService preService = (IPreguntaService) context.getBean("preguntaService");
			List<Pregunta> pre1 = (List<Pregunta>) preService.getAll();
			
			Pregunta p1 = new Pregunta(1, "Cuantas habitaiones", 1, true);
			Pregunta p2 = new Pregunta(2, "Hay cocina", 1, true);
			Pregunta p3 = new Pregunta(5, "Se enferma mucho", 1, true);
			
			p1.setCategoria(c2);
			p2.setCategoria(c2);
			p3.setCategoria(c1);
			p1.setPreguntaEncuestas(enc1);
			p2.setPreguntaEncuestas(enc1);
			p3.setPreguntaEncuestas(enc1);
			preService.add(p1);
			preService.add(p2);
			preService.add(p3);
			
			List<Pregunta> pre2 = (List<Pregunta>) preService.getAll();
			
			assertTrue(pre2.size() == pre1.size() + 3);
			
			//// Respuesta: add and getAll
			IRespuestaService respService = (IRespuestaService) context.getBean("respuestaService");
			List<Respuesta> resp1 = (List<Respuesta>) respService.getAll();
			
			Respuesta r1 = new Respuesta("0", 0, 3, 'A');
			Respuesta r2 = new Respuesta("1", 1, 2, 'B');
			Respuesta r3 = new Respuesta("2", 2, 1, 'C');
			Respuesta r4 = new Respuesta("Si", 0, 2, '1');
			Respuesta r5 = new Respuesta("No", 1, 0, '2');
			Respuesta r6 = new Respuesta("No hay respuesta", 2, 1, '3');
			
			respService.add(r1);
			respService.add(r2);
			respService.add(r3);
			respService.add(r4);
			respService.add(r5);
			respService.add(r6);
			
			List<Respuesta> resp2 = (List<Respuesta>) respService.getAll();
			
			assertTrue(resp2.size() == resp1.size() + 6);
			
			//// SesionEncuesta: add and getAll
			ISesionEncuestaService seService = (ISesionEncuestaService) context.getBean("sesionEncuestaService");
			List<SesionEncuesta> sesiones1 = (List<SesionEncuesta>) seService.getAll();
			
			SesionEncuesta se1 = new SesionEncuesta(1, "CooperanteZ", new Date());
			SesionEncuesta se2 = new SesionEncuesta(1, "CooperanteZ", new Date());
			SesionEncuesta se3 = new SesionEncuesta(1, "CooperanteZ", new Date());
			SesionEncuesta se4 = new SesionEncuesta(1, "CooperanteZ", new Date());
			SesionEncuesta se5 = new SesionEncuesta(1, "CooperanteZ", new Date());
			SesionEncuesta se6 = new SesionEncuesta(1, "CooperanteZ", new Date());
			SesionEncuesta se7 = new SesionEncuesta(1, "CooperanteZ", new Date());
			SesionEncuesta se8 = new SesionEncuesta(1, "CooperanteZ", new Date());
			SesionEncuesta se9 = new SesionEncuesta(1, "CooperanteZ", new Date());
			
			se1.setPregunta(preService.getOne(1));
			se1.setRespuesta(respService.getOne(1));
			se2.setPregunta(preService.getOne(1));
			se2.setRespuesta(respService.getOne(2));
			se3.setPregunta(preService.getOne(1));
			se3.setRespuesta(respService.getOne(3));
			
			se4.setPregunta(preService.getOne(2));
			se4.setRespuesta(respService.getOne(4));
			
			se5.setPregunta(preService.getOne(2));
			se5.setRespuesta(respService.getOne(5));

			se6.setPregunta(preService.getOne(2));
			se6.setRespuesta(respService.getOne(6));
			
			se7.setPregunta(preService.getOne(3));
			se7.setRespuesta(respService.getOne(4));
			
			se8.setPregunta(preService.getOne(3));
			se8.setRespuesta(respService.getOne(5));
			
			se9.setPregunta(preService.getOne(3));
			se9.setRespuesta(respService.getOne(6));
			
			seService.add(se1);
			seService.add(se2);
			seService.add(se3);
			seService.add(se4);
			seService.add(se5);
			seService.add(se6);
			seService.add(se7);
			seService.add(se8);
			seService.add(se9);
			
			List<SesionEncuesta> sesiones2 = (List<SesionEncuesta>) seService.getAll();
			
			assertTrue(sesiones2.size() == sesiones1.size() + 9);
			
			//// VersionEncuesta: add and getAll
			IVersionService verService = (IVersionService) context.getBean("versionService");
			List<Version> vers1 = (List<Version>) verService.getAll();
			
			Version v0 = new Version("CooperanteB", new Date(), "0.1.4");
			Version v1 = new Version("CooperanteB", new Date(), "0.1.4");
			Version v2 = new Version("CooperanteB", new Date(), "0.1.4");
			
			v0.setEncuesta(encService.getOne(1));
			v1.setEncuesta(encService.getOne(1));
			v2.setEncuesta(encService.getOne(1));
			v0.setPregunta(p1);
			v1.setPregunta(p2);
			v2.setPregunta(p3);
			
			verService.add(v0);
			verService.add(v1);
			verService.add(v2);
			
			List<Version> vers2 = (List<Version>) verService.getAll();
			
			assertTrue(vers2.size() == vers1.size() + 3);			
			
		} catch(Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	
	@After
	public void tearDown() throws Exception {
		this.context.close();
	}
}
