package br.com.alura.sistema.controller;

import br.com.alura.sistema.controller.dto.ProdutoDTO;
import br.com.alura.sistema.controller.form.ProdutoForm;
import br.com.alura.sistema.modelo.Produto;
import br.com.alura.sistema.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Base64;
import org.xml.sax.InputSource;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public List<ProdutoDTO> lista( ) {
        List<Produto> produtos = produtoRepository.findAll();
        return ProdutoDTO.converter(produtos);
    }

    @GetMapping("/{numeracao}")
    public ProdutoDTO detalhar(@PathVariable int numeracao){

        Produto produto = produtoRepository.findByNumeracao(numeracao);
        return new ProdutoDTO(produto);

    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastra(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
        Produto produto = form.converter();
        produtoRepository.save(produto);

        URI uri = uriBuilder.path("/produtos/{numeracao}").buildAndExpand(produto.getNumeracao()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDTO(produto));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastra_xml(@RequestBody String xml_base64, UriComponentsBuilder uriBuilder) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(xml_base64);
            String decodedString = new String(decodedBytes);
            InputSource xmlInput = new InputSource(new StringReader(decodedString));
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlInput);
            doc.getDocumentElement().normalize();
            Node ideNode = doc.getElementsByTagName("ide").item(0);
            Element ideElement = (Element) ideNode;
            String serie = ideElement.getElementsByTagName("serie").item(0).getTextContent();
            String nNF = ideElement.getElementsByTagName("nNF").item(0).getTextContent();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
            String dString = ideElement.getElementsByTagName("dhEmi").item(0).getTextContent();
            Date date = df.parse(dString);
            NodeList nodeList = doc.getElementsByTagName("det");
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node detNode = nodeList.item(itr);
                if (detNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element detElement = (Element) detNode;
                    Node prodNode = detElement.getElementsByTagName("prod").item(0);
                    Element prodElement = (Element) prodNode;
                    String cProd = prodElement.getElementsByTagName("cProd").item(0).getTextContent();
                    String xProd = prodElement.getElementsByTagName("xProd").item(0).getTextContent();
                    String qCom = prodElement.getElementsByTagName("qCom").item(0).getTextContent();
                    String uCom = prodElement.getElementsByTagName("uCom").item(0).getTextContent();
                    String vProd = prodElement.getElementsByTagName("vProd").item(0).getTextContent();
                    Node impostoNode = detElement.getElementsByTagName("imposto").item(0);
                    Element impostoElement = (Element) impostoNode;
                    Node IPINode = impostoElement.getElementsByTagName("IPI").item(0);
                    Element IPIElement = (Element) IPINode;
                    Node IPITribNode = IPIElement.getElementsByTagName("IPITrib").item(0);
                    Element IPITribElement = (Element) IPITribNode;
                    String vIPI = IPITribElement.getElementsByTagName("vIPI").item(0).getTextContent();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}


