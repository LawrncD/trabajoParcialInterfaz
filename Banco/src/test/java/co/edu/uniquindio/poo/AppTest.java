/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @SuppressWarnings("static-access")
    @Test
    public void shouldAnswerWithTrue() {
        LOG.info("Iniciado test shouldAnswerWithTrue");
        
        Banco Bancolombia = new Banco("Bancolombia");
        Ahorro cuenta_1 = new Ahorro("Lawrence", "Ospina", "1114541590", 0.001);
        Corriente cuenta_2 = new Corriente("Luisa", "Maria", "1116548789", 50000);

        Bancolombia.agregarCuenta(cuenta_2);
        Bancolombia.agregarCuenta(cuenta_1);
       
       System.out.println(cuenta_2.consultarSaldo());
       System.out.println(cuenta_1.consultarSaldo());
        cuenta_2.depositar(20000);
        cuenta_1.depositar(50000);
        System.out.println(cuenta_2.consultarSaldo());
         System.out.println(cuenta_1.consultarSaldo());
        Transaccion transaccion_1 = new Transaccion("1001", 20000, LocalDate.now(), "la buchona",  Tipo.DEPOSITO);
        cuenta_2.agregarTransaccion(transaccion_1);
        
        cuenta_2.retirar(10000);
        cuenta_1.retirar(10000);
      
        System.out.println(cuenta_2.consultarSaldo());
         System.out.println(cuenta_1.consultarSaldo());
        transaccion_1.transferirOtraCuenta("1114541590","1114541590",60000);
        System.out.println(cuenta_2.consultarSaldo());
        System.out.println(cuenta_1.consultarSaldo());

        
        LOG.info("Finalizando test shouldAnswerWithTrue");
    }

    @SuppressWarnings("static-access")
    @Test
    public void testDepositarValorNegativo() {
        LOG.info("Inicio test testDepositarValorNegativo ");
        Banco Bancolombia = new Banco("Davivienda");
        Ahorro cuneta_1 = new Ahorro("Lawrence", "Ospina", "1114541590", 0.001);
        Corriente cuenta_2 = new Corriente("Maria", "Valencia", "1235674670", 50000);
        Bancolombia.agregarCuenta(cuenta_2);
        Bancolombia.agregarCuenta(cuneta_1);

        assertThrows(Throwable.class , ()-> cuneta_1.depositar(-5000));
        assertThrows(Throwable.class , ()-> cuenta_2.depositar(-5000));


        LOG.info("Final test testDepositarValorNegativo ");
    }

    @SuppressWarnings("static-access")
    @Test
    public void testRetirarValorNegativo() {
        LOG.info("Inicio test testRetirarValorNegativo ");
        Banco Bancolombia = new Banco("Davivienda");
        Ahorro cuenta_1 = new Ahorro("Lawrence", "Ospina", "1114541590", 0.001);
        Corriente cuenta_2 = new Corriente("Maria", "Valencia", "1235674670", 50000);
        Bancolombia.agregarCuenta(cuenta_2);
        Bancolombia.agregarCuenta(cuenta_1);

        assertThrows(Throwable.class , ()-> cuenta_1.retirar(-5000));
        assertThrows(Throwable.class , ()-> cuenta_2.retirar(-5000));
        LOG.info("Final test testRetirarValorNegativo ");
    }
    @SuppressWarnings("static-access")
    @Test
    public void testtranferirValorNegativo() {
        LOG.info("Inicio test testtranferirValorNegativo ");
        LOG.info("Inicio test testRetirarValorNegativo ");
        Banco Bancolombia = new Banco("Davivienda");
        Ahorro cuenta_1 = new Ahorro("Lawrence", "Ospina", "1114541590", 0.001);
        Corriente cuenta_2 = new Corriente("Maria", "Valencia", "1235674670", 50000);
        Bancolombia.agregarCuenta(cuenta_2);
        Bancolombia.agregarCuenta(cuenta_1);
        Transaccion transaccion_1 = new Transaccion("1001", -20000, LocalDate.now(), "la buchona",  Tipo.DEPOSITO);
        assertThrows(Throwable.class , ()-> transaccion_1.transferirOtraCuenta("1114541590","1235674670",-20000));
        
        LOG.info("Final test testtranferirValorNegativo ");
    }

    
}