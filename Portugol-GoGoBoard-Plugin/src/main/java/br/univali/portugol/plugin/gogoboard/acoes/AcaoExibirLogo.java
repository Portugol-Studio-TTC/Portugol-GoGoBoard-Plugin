package br.univali.portugol.plugin.gogoboard.acoes;

import br.univali.portugol.plugin.gogoboard.GoGoBoardPlugin;
import br.univali.portugol.plugin.gogoboard.gerenciadores.GerenciadorConversao;
import br.univali.portugol.plugin.gogoboard.ui.telas.JanelaCodigoLogo;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Classe inicial do botão da ação exibir código Logo.
 *
 * @author Ailton Cardoso Jr
 * @version 1.0
 */
public class AcaoExibirLogo extends AbstractAction {

    private GoGoBoardPlugin plugin;

    /**
     * Construtor da ação exibir código Logo.
     *
     * @param plugin Instancia de plugin.
     */
    public AcaoExibirLogo(GoGoBoardPlugin plugin) {
        super("Exibe o código logo gerado para a GoGo Board", carregarIcone());
        this.plugin = plugin;
    }

    /**
     * Método para carregar o icone da ação.
     *
     * @return ImageIcon
     */
    private static Icon carregarIcone() {
        try {
            String caminho = "br/univali/portugol/plugin/gogoboard/imagens/code.png";
            Image imagem = ImageIO.read(AcaoEnviarByteCode.class.getClassLoader().getResourceAsStream(caminho));

            return new ImageIcon(imagem);
        } catch (IOException ex) {
            System.err.println("Erro ao carregar o icone do plugin na ação exibir código Logo");
            return null;
        }
    }

    /**
     * Método para abrir a janela do código Logo.
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        GerenciadorConversao gerenciadorConversao = new GerenciadorConversao(plugin);
        JanelaCodigoLogo janelaCodigoLogo = new JanelaCodigoLogo();
        String logo = gerenciadorConversao.converterPortugolParaLogo();
        janelaCodigoLogo.setCodigoLogo(logo);
        janelaCodigoLogo.setVisible(true);
    }
}
