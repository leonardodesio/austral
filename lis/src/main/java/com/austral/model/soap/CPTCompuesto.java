//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.12.06 a las 12:01:06 PM ART 
//


package com.austral.model.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CodigoPadre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Estudios">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Estudio" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="CodigoCPT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Cantidad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codigoPadre",
    "estudios"
})
@XmlRootElement(name = "CPTCompuesto")
public class CPTCompuesto {

    @XmlElement(name = "CodigoPadre", required = true)
    protected String codigoPadre;
    @XmlElement(name = "Estudios", required = true)
    protected CPTCompuesto.Estudios estudios;

    /**
     * Obtiene el valor de la propiedad codigoPadre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPadre() {
        return codigoPadre;
    }

    /**
     * Define el valor de la propiedad codigoPadre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPadre(String value) {
        this.codigoPadre = value;
    }

    /**
     * Obtiene el valor de la propiedad estudios.
     * 
     * @return
     *     possible object is
     *     {@link CPTCompuesto.Estudios }
     *     
     */
    public CPTCompuesto.Estudios getEstudios() {
        return estudios;
    }

    /**
     * Define el valor de la propiedad estudios.
     * 
     * @param value
     *     allowed object is
     *     {@link CPTCompuesto.Estudios }
     *     
     */
    public void setEstudios(CPTCompuesto.Estudios value) {
        this.estudios = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Estudio" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="CodigoCPT" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Cantidad" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "estudio"
    })
    public static class Estudios {

        @XmlElement(name = "Estudio")
        protected List<CPTCompuesto.Estudios.Estudio> estudio;

        /**
         * Gets the value of the estudio property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the estudio property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEstudio().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CPTCompuesto.Estudios.Estudio }
         * 
         * 
         */
        public List<CPTCompuesto.Estudios.Estudio> getEstudio() {
            if (estudio == null) {
                estudio = new ArrayList<CPTCompuesto.Estudios.Estudio>();
            }
            return this.estudio;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="CodigoCPT" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Cantidad" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "codigoCPT",
            "cantidad"
        })
        public static class Estudio {

            @XmlElement(name = "CodigoCPT", required = true)
            protected String codigoCPT;
            @XmlElement(name = "Cantidad", required = true)
            protected String cantidad;

            /**
             * Obtiene el valor de la propiedad codigoCPT.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodigoCPT() {
                return codigoCPT;
            }

            /**
             * Define el valor de la propiedad codigoCPT.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodigoCPT(String value) {
                this.codigoCPT = value;
            }

            /**
             * Obtiene el valor de la propiedad cantidad.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCantidad() {
                return cantidad;
            }

            /**
             * Define el valor de la propiedad cantidad.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCantidad(String value) {
                this.cantidad = value;
            }

        }

    }

}
