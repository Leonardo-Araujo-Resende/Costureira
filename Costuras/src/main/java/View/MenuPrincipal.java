
package View;

import Controller.ControllerMaster;
import Controller.MpClientesController;
import Controller.MpEditarServicoController;
import Controller.MpPerfilController;
import Model.Costureira;
import Model.StatusServico;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class MenuPrincipal extends javax.swing.JFrame {

    private final Costureira costureiraLogada;
    
    private final MpClientesController mpClientescontroller;
    private final MpEditarServicoController mpEditarServicoControoler;
    private final MpPerfilController mpPerfilController;
    
    public MenuPrincipal(Costureira costureiraLogada) {
        ControllerMaster.setIcone(this);

        initComponents();
        
        this.setTitle(costureiraLogada.getNome());
        TodosPanels.setSelectedIndex(2);
        
        this.costureiraLogada = costureiraLogada;
        
        mpClientescontroller = new MpClientesController(this);
        mpClientescontroller.atualizarComboBoxCliente();
        mpClientescontroller.atualizarLabels();
        mpClientescontroller.preencherTabelaServicos();
        
        mpEditarServicoControoler = new MpEditarServicoController(this);
        mpEditarServicoControoler.atualizaTabela();
        
        mpPerfilController = new MpPerfilController(this);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TodosPanels = new javax.swing.JTabbedPane();
        PanelClientes = new javax.swing.JPanel();
        Panel = new javax.swing.JPanel();
        IdLabel = new javax.swing.JLabel();
        NomeLabel = new javax.swing.JLabel();
        EnderecoLabel = new javax.swing.JLabel();
        TelefoneLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaServicosClientes = new javax.swing.JTable();
        QntServicoLabel = new javax.swing.JLabel();
        TipoPrefLabel = new javax.swing.JLabel();
        CostureiraPrefLabel = new javax.swing.JLabel();
        ValorTotalLabel = new javax.swing.JLabel();
        MediaValorLabel = new javax.swing.JLabel();
        BotaoReload = new javax.swing.JToggleButton();
        ComboBoxCliente = new javax.swing.JComboBox<>();
        BotaoCiarCliente = new javax.swing.JToggleButton();
        BotaoEdiarCliente = new javax.swing.JToggleButton();
        EditarServico = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaEditarServicos = new javax.swing.JTable();
        BotaoEditarServico = new javax.swing.JToggleButton();
        BotaoCriarServico = new javax.swing.JToggleButton();
        ComboBoxStatus = new javax.swing.JComboBox<>();
        LabelFiltros1 = new javax.swing.JLabel();
        LabelFiltros = new javax.swing.JLabel();
        BotaoStatusPedido = new javax.swing.JToggleButton();
        BotaoStatusProntoEntrega = new javax.swing.JToggleButton();
        BotaoStatusEntregue = new javax.swing.JToggleButton();
        BotaoExcluirCliente1 = new javax.swing.JToggleButton();
        PanelPerfil = new javax.swing.JPanel();
        IdLabelCost = new javax.swing.JLabel();
        NomeLabelCost = new javax.swing.JLabel();
        SenhaLabelCost = new javax.swing.JLabel();
        LoginLabelCost = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaStatus = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TabelaMes = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        TabelaTIpo = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuPerfil = new javax.swing.JMenu();
        MenuItemAdicionarTipoServico = new javax.swing.JMenuItem();
        MenuItemVisualizarPerfil = new javax.swing.JMenuItem();
        MenuItemSair = new javax.swing.JMenuItem();
        MenuClientes = new javax.swing.JMenu();
        MenuItemAdicionarCliente = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        MenuServicos = new javax.swing.JMenu();
        MenuItemAdicionarServico = new javax.swing.JMenuItem();
        MenuItemEditarServicos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel.setBackground(new java.awt.Color(0, 0, 0));

        IdLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        IdLabel.setForeground(new java.awt.Color(0, 67, 197));
        IdLabel.setText("15");

        NomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        NomeLabel.setForeground(new java.awt.Color(0, 67, 197));
        NomeLabel.setText("Gabriela Leite Fernandes");

        EnderecoLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EnderecoLabel.setText("Avenida Jucelino Kubistheck 120, Bairro Industrial, Contagem");

        TelefoneLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TelefoneLabel.setText("(31) 9 8238-5533");

        TabelaServicosClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Status", "Tipo", "Valor (R$)", "CustoPecas (R$)", "DataPedido", "DataEntrega", "Observacao", "Costureira"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabelaServicosClientes);
        if (TabelaServicosClientes.getColumnModel().getColumnCount() > 0) {
            TabelaServicosClientes.getColumnModel().getColumn(0).setMinWidth(50);
            TabelaServicosClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            TabelaServicosClientes.getColumnModel().getColumn(0).setMaxWidth(50);
            TabelaServicosClientes.getColumnModel().getColumn(3).setMinWidth(70);
            TabelaServicosClientes.getColumnModel().getColumn(3).setPreferredWidth(70);
            TabelaServicosClientes.getColumnModel().getColumn(3).setMaxWidth(70);
            TabelaServicosClientes.getColumnModel().getColumn(4).setMinWidth(110);
            TabelaServicosClientes.getColumnModel().getColumn(4).setPreferredWidth(110);
            TabelaServicosClientes.getColumnModel().getColumn(4).setMaxWidth(110);
        }

        QntServicoLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        QntServicoLabel.setText("Quantidade de Serviços: ");

        TipoPrefLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TipoPrefLabel.setText("Tipo preferido:");

        CostureiraPrefLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CostureiraPrefLabel.setText("Costureira preferida:");

        ValorTotalLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ValorTotalLabel.setText("Valor total:");

        MediaValorLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MediaValorLabel.setText("Média valor:");

        BotaoReload.setBackground(new java.awt.Color(0, 0, 0));
        BotaoReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reloadIcon32.png"))); // NOI18N
        BotaoReload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoReloadActionPerformed(evt);
            }
        });

        ComboBoxCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ComboBoxCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxClienteMouseClicked(evt);
            }
        });
        ComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxClienteActionPerformed(evt);
            }
        });

        BotaoCiarCliente.setBackground(new java.awt.Color(0, 67, 197));
        BotaoCiarCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotaoCiarCliente.setForeground(new java.awt.Color(255, 255, 255));
        BotaoCiarCliente.setText("Criar");
        BotaoCiarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoCiarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCiarClienteActionPerformed(evt);
            }
        });

        BotaoEdiarCliente.setBackground(new java.awt.Color(0, 67, 197));
        BotaoEdiarCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotaoEdiarCliente.setForeground(new java.awt.Color(255, 255, 255));
        BotaoEdiarCliente.setText("Editar");
        BotaoEdiarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoEdiarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEdiarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(QntServicoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CostureiraPrefLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(ValorTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TipoPrefLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(MediaValorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                                .addComponent(BotaoCiarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotaoEdiarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PanelLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(IdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(NomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(EnderecoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TelefoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(PanelLayout.createSequentialGroup()
                                    .addComponent(ComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BotaoReload, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 14, Short.MAX_VALUE))))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoReload, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NomeLabel)
                        .addComponent(IdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(TelefoneLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EnderecoLabel)))
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ValorTotalLabel)
                            .addComponent(TipoPrefLabel))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addComponent(QntServicoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CostureiraPrefLabel)
                            .addComponent(MediaValorLabel))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoCiarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoEdiarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        PanelClientes.add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-12, 16, 1200, 690));

        TodosPanels.addTab("tab1", PanelClientes);

        EditarServico.setBackground(new java.awt.Color(0, 0, 0));
        EditarServico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Segoe UI Black", 1, 31)); // NOI18N
        Titulo.setForeground(new java.awt.Color(0, 67, 197));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Editar Serviço");
        EditarServico.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1180, -1));

        TabelaEditarServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Cliente", "Status", "Tipo", "Valor (R$)", "Custo Pecas (R$)", "Data Pedido", "Data Entrega", "Observacao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaEditarServicos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TabelaEditarServicos);
        if (TabelaEditarServicos.getColumnModel().getColumnCount() > 0) {
            TabelaEditarServicos.getColumnModel().getColumn(0).setMinWidth(50);
            TabelaEditarServicos.getColumnModel().getColumn(0).setPreferredWidth(50);
            TabelaEditarServicos.getColumnModel().getColumn(0).setMaxWidth(50);
            TabelaEditarServicos.getColumnModel().getColumn(3).setMinWidth(100);
            TabelaEditarServicos.getColumnModel().getColumn(3).setPreferredWidth(100);
            TabelaEditarServicos.getColumnModel().getColumn(3).setMaxWidth(100);
            TabelaEditarServicos.getColumnModel().getColumn(4).setMinWidth(100);
            TabelaEditarServicos.getColumnModel().getColumn(4).setPreferredWidth(100);
            TabelaEditarServicos.getColumnModel().getColumn(4).setMaxWidth(100);
            TabelaEditarServicos.getColumnModel().getColumn(5).setMinWidth(100);
            TabelaEditarServicos.getColumnModel().getColumn(5).setPreferredWidth(100);
            TabelaEditarServicos.getColumnModel().getColumn(5).setMaxWidth(100);
            TabelaEditarServicos.getColumnModel().getColumn(6).setMinWidth(120);
            TabelaEditarServicos.getColumnModel().getColumn(6).setPreferredWidth(120);
            TabelaEditarServicos.getColumnModel().getColumn(6).setMaxWidth(120);
            TabelaEditarServicos.getColumnModel().getColumn(7).setMinWidth(120);
            TabelaEditarServicos.getColumnModel().getColumn(7).setPreferredWidth(120);
            TabelaEditarServicos.getColumnModel().getColumn(7).setMaxWidth(120);
        }

        EditarServico.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 1130, 390));

        BotaoEditarServico.setBackground(new java.awt.Color(0, 67, 197));
        BotaoEditarServico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotaoEditarServico.setForeground(new java.awt.Color(255, 255, 255));
        BotaoEditarServico.setText("Editar");
        BotaoEditarServico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoEditarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarServicoActionPerformed(evt);
            }
        });
        EditarServico.add(BotaoEditarServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 620, 350, 50));

        BotaoCriarServico.setBackground(new java.awt.Color(0, 67, 197));
        BotaoCriarServico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotaoCriarServico.setForeground(new java.awt.Color(255, 255, 255));
        BotaoCriarServico.setText("Criar");
        BotaoCriarServico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoCriarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCriarServicoActionPerformed(evt);
            }
        });
        EditarServico.add(BotaoCriarServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 350, 50));

        ComboBoxStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "PEDIDO", "PRONTO_ENTREGA", "ENTREGUE" }));
        ComboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxStatusActionPerformed(evt);
            }
        });
        EditarServico.add(ComboBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 140, 40));

        LabelFiltros1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelFiltros1.setForeground(new java.awt.Color(0, 67, 197));
        LabelFiltros1.setText("Opções Status");
        EditarServico.add(LabelFiltros1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 150, -1));

        LabelFiltros.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelFiltros.setForeground(new java.awt.Color(0, 67, 197));
        LabelFiltros.setText("Filtros");
        EditarServico.add(LabelFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        BotaoStatusPedido.setBackground(new java.awt.Color(0, 67, 197));
        BotaoStatusPedido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotaoStatusPedido.setForeground(new java.awt.Color(255, 255, 255));
        BotaoStatusPedido.setText("PEDIDO");
        BotaoStatusPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoStatusPedidoActionPerformed(evt);
            }
        });
        EditarServico.add(BotaoStatusPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 150, 40));

        BotaoStatusProntoEntrega.setBackground(new java.awt.Color(0, 67, 197));
        BotaoStatusProntoEntrega.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotaoStatusProntoEntrega.setForeground(new java.awt.Color(255, 255, 255));
        BotaoStatusProntoEntrega.setText("PRONTO ENTREGA");
        BotaoStatusProntoEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoStatusProntoEntregaActionPerformed(evt);
            }
        });
        EditarServico.add(BotaoStatusProntoEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 160, 150, 40));

        BotaoStatusEntregue.setBackground(new java.awt.Color(0, 67, 197));
        BotaoStatusEntregue.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotaoStatusEntregue.setForeground(new java.awt.Color(255, 255, 255));
        BotaoStatusEntregue.setText("ENTREGUE");
        BotaoStatusEntregue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoStatusEntregueActionPerformed(evt);
            }
        });
        EditarServico.add(BotaoStatusEntregue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 160, 150, 40));

        BotaoExcluirCliente1.setBackground(new java.awt.Color(158, 0, 0));
        BotaoExcluirCliente1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotaoExcluirCliente1.setForeground(new java.awt.Color(255, 255, 255));
        BotaoExcluirCliente1.setText("Excluir");
        BotaoExcluirCliente1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoExcluirCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirCliente1ActionPerformed(evt);
            }
        });
        EditarServico.add(BotaoExcluirCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 620, 350, 50));

        TodosPanels.addTab("tab2", EditarServico);

        PanelPerfil.setBackground(new java.awt.Color(0, 0, 0));
        PanelPerfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IdLabelCost.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        IdLabelCost.setForeground(new java.awt.Color(0, 67, 197));
        IdLabelCost.setText("15");
        PanelPerfil.add(IdLabelCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 70, -1));

        NomeLabelCost.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        NomeLabelCost.setForeground(new java.awt.Color(0, 67, 197));
        NomeLabelCost.setText("Gabriela Leite Fernandes");
        PanelPerfil.add(NomeLabelCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 600, -1));

        SenhaLabelCost.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SenhaLabelCost.setText("Senha: **********");
        PanelPerfil.add(SenhaLabelCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 310, -1));

        LoginLabelCost.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LoginLabelCost.setText("Login: Gabriela");
        PanelPerfil.add(LoginLabelCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 310, -1));

        TabelaStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Status Pedido", "Quantidade", "Valor a Receber"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaStatus.setRowMargin(5);
        jScrollPane3.setViewportView(TabelaStatus);

        PanelPerfil.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 520, 180));

        TabelaMes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mês", "Quantidade Serviços", "Valor Recebeu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(TabelaMes);

        PanelPerfil.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, 520, 180));

        TabelaTIpo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tipo Pedido", "Quantidade", "Valor a Receber"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(TabelaTIpo);

        PanelPerfil.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 1120, 180));

        TodosPanels.addTab("tab3", PanelPerfil);

        getContentPane().add(TodosPanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -60, 1200, 730));

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        MenuPerfil.setText("Perfil");

        MenuItemAdicionarTipoServico.setText("Adicionar Tipo Serviço");
        MenuItemAdicionarTipoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemAdicionarTipoServicoActionPerformed(evt);
            }
        });
        MenuPerfil.add(MenuItemAdicionarTipoServico);

        MenuItemVisualizarPerfil.setText("Visualizar");
        MenuItemVisualizarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemVisualizarPerfilActionPerformed(evt);
            }
        });
        MenuPerfil.add(MenuItemVisualizarPerfil);

        MenuItemSair.setText("Sair");
        MenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemSairActionPerformed(evt);
            }
        });
        MenuPerfil.add(MenuItemSair);

        jMenuBar1.add(MenuPerfil);

        MenuClientes.setText("Clientes");

        MenuItemAdicionarCliente.setText("Adicionar");
        MenuItemAdicionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemAdicionarClienteActionPerformed(evt);
            }
        });
        MenuClientes.add(MenuItemAdicionarCliente);

        jMenuItem4.setText("Visualizar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        MenuClientes.add(jMenuItem4);

        jMenuBar1.add(MenuClientes);

        MenuServicos.setText("Serviços");

        MenuItemAdicionarServico.setText("Adicionar");
        MenuItemAdicionarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemAdicionarServicoActionPerformed(evt);
            }
        });
        MenuServicos.add(MenuItemAdicionarServico);

        MenuItemEditarServicos.setText("Editar");
        MenuItemEditarServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemEditarServicosActionPerformed(evt);
            }
        });
        MenuServicos.add(MenuItemEditarServicos);

        jMenuBar1.add(MenuServicos);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemVisualizarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemVisualizarPerfilActionPerformed
        TodosPanels.setSelectedIndex(2);
        mpPerfilController.atualizarDados();
        
    }//GEN-LAST:event_MenuItemVisualizarPerfilActionPerformed

    private void MenuItemAdicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemAdicionarClienteActionPerformed
        CriarCliente menu = new CriarCliente(costureiraLogada);
        menu.setVisible(true);
    }//GEN-LAST:event_MenuItemAdicionarClienteActionPerformed

    private void MenuItemAdicionarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemAdicionarServicoActionPerformed
        CriarServico menu = new CriarServico(costureiraLogada);
        menu.setVisible(true);
    }//GEN-LAST:event_MenuItemAdicionarServicoActionPerformed

    private void MenuItemAdicionarTipoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemAdicionarTipoServicoActionPerformed
        CriarTipoServico menu = new CriarTipoServico(costureiraLogada);
        menu.setVisible(true);
    }//GEN-LAST:event_MenuItemAdicionarTipoServicoActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        TodosPanels.setSelectedIndex(0);
        mpClientescontroller.atualizarComboBoxCliente();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void ComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxClienteActionPerformed
        if(mpClientescontroller.isMudandoComboBoxCliente()) return;
        
        mpClientescontroller.atualizarLabels();
        mpClientescontroller.preencherTabelaServicos();
        
    }//GEN-LAST:event_ComboBoxClienteActionPerformed

    private void ComboBoxClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxClienteMouseClicked
      
    }//GEN-LAST:event_ComboBoxClienteMouseClicked

    private void BotaoReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoReloadActionPerformed
        mpClientescontroller.atualizarComboBoxCliente();
    }//GEN-LAST:event_BotaoReloadActionPerformed

    private void BotaoEditarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarServicoActionPerformed
        mpEditarServicoControoler.criarTelaEditarServico();
    }//GEN-LAST:event_BotaoEditarServicoActionPerformed

    private void BotaoCriarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCriarServicoActionPerformed
        CriarCliente menu = new CriarCliente(getCostureiraLogada());
        menu.setVisible(true);
    }//GEN-LAST:event_BotaoCriarServicoActionPerformed

    private void ComboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxStatusActionPerformed
        
        mpEditarServicoControoler.atualizaTabela();
    }//GEN-LAST:event_ComboBoxStatusActionPerformed

    private void MenuItemEditarServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemEditarServicosActionPerformed
        TodosPanels.setSelectedIndex(1);
    }//GEN-LAST:event_MenuItemEditarServicosActionPerformed

    private void BotaoStatusEntregueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoStatusEntregueActionPerformed
        mpEditarServicoControoler.atualizaStatusServicoTabela( StatusServico.ENTREGUE.name() );
    }//GEN-LAST:event_BotaoStatusEntregueActionPerformed

    private void BotaoStatusPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoStatusPedidoActionPerformed
        mpEditarServicoControoler.atualizaStatusServicoTabela( StatusServico.PEDIDO.name() );
    }//GEN-LAST:event_BotaoStatusPedidoActionPerformed

    private void BotaoStatusProntoEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoStatusProntoEntregaActionPerformed
        mpEditarServicoControoler.atualizaStatusServicoTabela( StatusServico.PRONTO_ENTREGA.name() );
    }//GEN-LAST:event_BotaoStatusProntoEntregaActionPerformed

    private void BotaoCiarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCiarClienteActionPerformed
        // TODO add your handling codeas here:
    }//GEN-LAST:event_BotaoCiarClienteActionPerformed

    private void BotaoEdiarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEdiarClienteActionPerformed
        EditarCliente menu = new EditarCliente(mpClientescontroller.recuperarClienteSelecionado());
        menu.setVisible(true);
    }//GEN-LAST:event_BotaoEdiarClienteActionPerformed

    private void BotaoExcluirCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirCliente1ActionPerformed

        mpEditarServicoControoler.deletarServicoSelecionado();
    }//GEN-LAST:event_BotaoExcluirCliente1ActionPerformed

    private void MenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemSairActionPerformed
       dispose();
       new Login().setVisible(true);
    }//GEN-LAST:event_MenuItemSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotaoCiarCliente;
    private javax.swing.JToggleButton BotaoCriarServico;
    private javax.swing.JToggleButton BotaoEdiarCliente;
    private javax.swing.JToggleButton BotaoEditarServico;
    private javax.swing.JToggleButton BotaoExcluirCliente1;
    private javax.swing.JToggleButton BotaoReload;
    private javax.swing.JToggleButton BotaoStatusEntregue;
    private javax.swing.JToggleButton BotaoStatusPedido;
    private javax.swing.JToggleButton BotaoStatusProntoEntrega;
    private javax.swing.JComboBox<String> ComboBoxCliente;
    private javax.swing.JComboBox<String> ComboBoxStatus;
    private javax.swing.JLabel CostureiraPrefLabel;
    private javax.swing.JPanel EditarServico;
    private javax.swing.JLabel EnderecoLabel;
    private javax.swing.JLabel IdLabel;
    private javax.swing.JLabel IdLabelCost;
    private javax.swing.JLabel LabelFiltros;
    private javax.swing.JLabel LabelFiltros1;
    private javax.swing.JLabel LoginLabelCost;
    private javax.swing.JLabel MediaValorLabel;
    private javax.swing.JMenu MenuClientes;
    private javax.swing.JMenuItem MenuItemAdicionarCliente;
    private javax.swing.JMenuItem MenuItemAdicionarServico;
    private javax.swing.JMenuItem MenuItemAdicionarTipoServico;
    private javax.swing.JMenuItem MenuItemEditarServicos;
    private javax.swing.JMenuItem MenuItemSair;
    private javax.swing.JMenuItem MenuItemVisualizarPerfil;
    private javax.swing.JMenu MenuPerfil;
    private javax.swing.JMenu MenuServicos;
    private javax.swing.JLabel NomeLabel;
    private javax.swing.JLabel NomeLabelCost;
    private javax.swing.JPanel Panel;
    private javax.swing.JPanel PanelClientes;
    private javax.swing.JPanel PanelPerfil;
    private javax.swing.JLabel QntServicoLabel;
    private javax.swing.JLabel SenhaLabelCost;
    private javax.swing.JTable TabelaEditarServicos;
    private javax.swing.JTable TabelaMes;
    private javax.swing.JTable TabelaServicosClientes;
    private javax.swing.JTable TabelaStatus;
    private javax.swing.JTable TabelaTIpo;
    private javax.swing.JLabel TelefoneLabel;
    private javax.swing.JLabel TipoPrefLabel;
    private javax.swing.JLabel Titulo;
    private javax.swing.JTabbedPane TodosPanels;
    private javax.swing.JLabel ValorTotalLabel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
    
    public void exibirMensagem(String mensagemExibida){
        JOptionPane.showMessageDialog(this, mensagemExibida);
    }
    
    
    public JComboBox<String> getComboBoxStatus(){
        return ComboBoxStatus;
    }
    
    public JComboBox<String> getComboBoxCliente() {
        return ComboBoxCliente;
    }

    public void setComboBoxCliente(JComboBox<String> ComboBoxCliente) {
        this.ComboBoxCliente = ComboBoxCliente;
    }

    public JLabel getIdLabel() {
        return IdLabel;
    }

    public void setIdLabel(JLabel IdLabel) {
        this.IdLabel = IdLabel;
    }
    
    

    public JLabel getCostureiraPrefLabel() {
        return CostureiraPrefLabel;
    }

    public void setCostureiraPrefLabel(JLabel CostureiraPrefLabel) {
        this.CostureiraPrefLabel = CostureiraPrefLabel;
    }

    public JLabel getEnderecoLabel() {
        return EnderecoLabel;
    }

    public void setEnderecoLabel(JLabel EnderecoLabel) {
        this.EnderecoLabel = EnderecoLabel;
    }

    
    public Costureira getCostureiraLogada() {
        return costureiraLogada;
    }
    
    public JLabel getMediaValorLabel() {
        return MediaValorLabel;
    }

    public void setMediaValorLabel(JLabel MediaValorLabel) {
        this.MediaValorLabel = MediaValorLabel;
    }

    public JLabel getNomeLabel() {
        return NomeLabel;
    }

    public void setNomeLabel(JLabel NomeLabel) {
        this.NomeLabel = NomeLabel;
    }

    public JLabel getQntServicoLabel() {
        return QntServicoLabel;
    }

    public void setQntServicoLabel(JLabel QntServicoLabel) {
        this.QntServicoLabel = QntServicoLabel;
    }

    public JTable getTabelaEditarServicos() {
        return TabelaEditarServicos;
    }

    public void setTabelaEditarServicos(JTable TabelaEditarServicos) {
        this.TabelaEditarServicos = TabelaEditarServicos;
    }

    public JTable getTabelaServicosClientes() {
        return TabelaServicosClientes;
    }

    public void setTabelaServicosClientes(JTable TabelaServicosClientes) {
        this.TabelaServicosClientes = TabelaServicosClientes;
    }

    

    public JLabel getTelefoneLabel() {
        return TelefoneLabel;
    }

    public void setTelefoneLabel(JLabel TelefoneLabel) {
        this.TelefoneLabel = TelefoneLabel;
    }


    public JLabel getTipoPrefLabel() {
        return TipoPrefLabel;
    }

    public void setTipoPrefLabel(JLabel TipoPrefLabel) {
        this.TipoPrefLabel = TipoPrefLabel;
    }

    public JLabel getValorTotalLabel() {
        return ValorTotalLabel;
    }

    public void setValorTotalLabel(JLabel ValorTotalLabel) {
        this.ValorTotalLabel = ValorTotalLabel;
    }

    public javax.swing.JToggleButton getBotaoStatusEntregue() {
        return BotaoStatusEntregue;
    }

    public javax.swing.JToggleButton getBotaoStatusPedido() {
        return BotaoStatusPedido;
    }

    public javax.swing.JToggleButton getBotaoStatusProntoEntrega() {
        return BotaoStatusProntoEntrega;
    }

    public JLabel getIdLabelCost() {
        return IdLabelCost;
    }

    public JLabel getNomeLabelCost() {
        return NomeLabelCost;
    }

    public JLabel getSenhaLabelCost() {
        return SenhaLabelCost;
    }

    public JTable getTabelaMes() {
        return TabelaMes;
    }

    public JTable getTabelaStatus() {
        return TabelaStatus;
    }

    public JTable getTabelaTIpo() {
        return TabelaTIpo;
    }

    public JLabel getLoginLabelCost() {
        return LoginLabelCost;
    }
    
    
    
}
