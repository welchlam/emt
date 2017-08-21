package com.welch.emt.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2017-6-10.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"formName", "fieldName"}))
public class FormConfiguration {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String formName;
    @Column(nullable = false)
    private String fieldName;
    @Column(nullable = false)
    private String fieldType;
    @Column(nullable = false)
    private int seq;
    private String styles;
    @Column(nullable = false)
    private boolean required = true;
    private String requiredError;
    private String defaultValue;
    private String srcValues;
    @Column(nullable = false)
    private boolean visible = true;
    @Column(nullable = false)
    private boolean enabled = true;
    @Column(nullable = false)
    private boolean readonly = false;
    private String description;
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getStyles() {
        return styles;
    }

    public void setStyles(String styles) {
        this.styles = styles;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getRequiredError() {
        return requiredError;
    }

    public void setRequiredError(String requiredError) {
        this.requiredError = requiredError;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getSrcValues() {
        return srcValues;
    }

    public void setSrcValues(String srcValues) {
        this.srcValues = srcValues;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isReadonly() {
        return readonly;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
