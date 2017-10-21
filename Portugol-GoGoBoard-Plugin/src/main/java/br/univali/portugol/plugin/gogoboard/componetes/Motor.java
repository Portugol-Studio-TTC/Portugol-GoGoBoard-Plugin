package br.univali.portugol.plugin.gogoboard.componetes;

import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import br.univali.portugol.plugin.gogoboard.driver.GerenciadorDeDriver;
import br.univali.portugol.plugin.gogoboard.driver.GoGoDriver;
import br.univali.portugol.plugin.gogoboard.util.UtilGoGoBoard;

/**
 *
 * @author Ailton Cardoso Jr
 */
public class Motor {

    protected int numMotor;
    protected boolean ligado;
    protected boolean direita;
    protected GoGoDriver goGoDriver;

    public Motor(int numMotor, UtilGoGoBoard.TipoDriver tipoDriver) {
        this.numMotor = numMotor;
        this.goGoDriver = GerenciadorDeDriver.getGoGoDriver(tipoDriver);
    }

    public int getNumMotor() {
        return numMotor;
    }

    public void setNumMotor(int numMotor) {
        this.numMotor = numMotor;
    }

    public boolean isLigado() {
        return ligado;
    }

    public boolean isDireita() {
        return direita;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public void setDireita(boolean direita) {
        this.direita = direita;
    }
    
    protected void selecionarMotor(int numMotor) throws ErroExecucaoBiblioteca {
        byte[] cmd = new byte[GoGoDriver.TAMANHO_PACOTE];
        cmd[GoGoDriver.ID_COMANDO] = GoGoDriver.CMD_SET_PORTAS_ATIVAS;
        cmd[GoGoDriver.PARAMETRO1] = (byte) numMotor;
        goGoDriver.enviarComando(cmd);
    }
}