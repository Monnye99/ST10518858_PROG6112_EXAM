import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ProductApp extends JFrame {
    private JTextField txtCustomer = new JTextField(20);
    private JComboBox<String> cmbProduct = new JComboBox<>(new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});
    private JTextField txtPrice = new JTextField(20);
    private JTextArea txtOutput = new JTextArea(6, 30);
    private JButton btnProcess = new JButton("PROCESS");

    public ProductApp() {
        setTitle("Product App");
        setLayout(new BorderLayout());

        // TOP PANEL 
        JPanel top = new JPanel(new GridLayout(4, 2, 10, 10));
        top.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        top.add(new JLabel("Customer Name:"));
        top.add(txtCustomer);
        top.add(new JLabel("Select Product:"));
        top.add(cmbProduct);
        top.add(new JLabel("Enter Price:"));
        top.add(txtPrice);
        top.add(new JLabel(""));
        top.add(btnProcess);
        add(top, BorderLayout.NORTH);

        // OUTPUT
        txtOutput.setEditable(false);
        add(new JScrollPane(txtOutput), BorderLayout.CENTER);

        // MENU - File / Edit like screenshot
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem miSave = new JMenuItem("Save");
        JMenuItem miExit = new JMenuItem("Exit");
        fileMenu.add(miSave);
        fileMenu.add(miExit);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem miClear = new JMenuItem("Clear");
        editMenu.add(miClear);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);

        // Actions
        btnProcess.addActionListener(e -> processSale());
        miSave.addActionListener(e -> saveToFile());
        miExit.addActionListener(e -> System.exit(0));
        miClear.addActionListener(e -> {
            txtCustomer.setText("");
            txtPrice.setText("");
            txtOutput.setText("");
            cmbProduct.setSelectedIndex(0);
        });

        setSize(450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void processSale() {
        try {
            String customer = txtCustomer.getText();
            String product = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            if (customer.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter Customer Name");
                return;
            }

            ProductSale sale = new ProductSale(customer, product, price);

            String result = "Customer Name: " + sale.getCustomerName() + "\n"
                    + "Product Name: " + sale.getProductName() + "\n"
                    + "Price: R" + sale.getPrice() + "\n"
                    + "VAT Amount (15%): R" + sale.getVATAmount() + "\n"
                    + "Commission Amount (5%): R" + sale.getCommissionAmount() + "\n"
                    + "Total Sale Amount: R" + sale.getTotalSaleAmount();

            txtOutput.setText(result);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid price");
        }
    }

    private void saveToFile() {
        if (txtOutput.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Process a sale first");
            return;
        }
        try (PrintWriter out = new PrintWriter(new FileWriter("ProductSales.txt"))) {
            out.println(txtOutput.getText());
            JOptionPane.showMessageDialog(this, "Saved to ProductSales.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Could not save: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp());
    }
}