package model;

import com.github.ilevshevich.mapper.delimited.annotation.DelimitedField;
import com.github.ilevshevich.mapper.delimited.annotation.DelimitedRecord;
import com.github.ilevshevich.mapper.delimited.annotation.extra.*;
import com.github.ilevshevich.mapper.delimited.model.DelimetedModel;
import com.github.ilevshevich.mapper.delimited.transform.extra.DateTransform;
import com.github.ilevshevich.mapper.delimited.transform.extra.IntegerTransform;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@DelimitedRecord(delimiter = "|")
public class DelimitedModelTest implements DelimetedModel {
    @BigDecimalDelimitedField(index = 0)
    private BigDecimal _0;

    @BigIntegerDelimitedField(index = 1)
    private BigInteger _1;

    @BooleanDelimitedField(index = 2)
    private Boolean _2;

    @DateDelimitedField(index = 3, dateFormat = "yyyy-MM-dd")
    private Date _3;

    @DoubleDelimitedField(index = 4)
    private Double _4;

    @FloatDelimitedField(index = 5)
    private Float _5;

    @IntegerDelimitedField(index = 6)
    private Integer _6;

    @LongDelimitedField(index = 7)
    private Long _7;

    @StringDelimitedField(index = 8)
    private String _8;

    @BigDecimalDelimitedField(index = 9, scale = 4)
    private BigDecimal _9;

    @DoubleDelimitedField(index = 10, scale = 4)
    private Double _10;

    @FloatDelimitedField(index = 11, scale = 4)
    private Float _11;

    @BigDecimalDelimitedField(index = 12, scale = 4, mode = 1 /*ROUND_DOWN*/)
    private BigDecimal _12;

    @DoubleDelimitedField(index = 13, scale = 4, mode = 1 /*ROUND_DOWN*/)
    private Double _13;

    @FloatDelimitedField(index = 14, scale = 4, mode = 1 /*ROUND_DOWN*/)
    private Float _14;

    @DelimitedField(index = 15, transform = IntegerTransform.class)
    private Integer _15;

    @DelimitedField(index = 16, transform = DateTransform.class)
    private Date _16;

    @IntegerDelimitedField(index = 17)
    private Integer _17;

    public BigDecimal get_0() {
        return _0;
    }

    public void set_0(BigDecimal _0) {
        this._0 = _0;
    }

    public BigInteger get_1() {
        return _1;
    }

    public void set_1(BigInteger _1) {
        this._1 = _1;
    }

    public Boolean get_2() {
        return _2;
    }

    public void set_2(Boolean _2) {
        this._2 = _2;
    }

    public Date get_3() {
        return _3;
    }

    public void set_3(Date _3) {
        this._3 = _3;
    }

    public Double get_4() {
        return _4;
    }

    public void set_4(Double _4) {
        this._4 = _4;
    }

    public Float get_5() {
        return _5;
    }

    public void set_5(Float _5) {
        this._5 = _5;
    }

    public Integer get_6() {
        return _6;
    }

    public void set_6(Integer _6) {
        this._6 = _6;
    }

    public Long get_7() {
        return _7;
    }

    public void set_7(Long _7) {
        this._7 = _7;
    }

    public String get_8() {
        return _8;
    }

    public void set_8(String _8) {
        this._8 = _8;
    }

    public BigDecimal get_9() {
        return _9;
    }

    public void set_9(BigDecimal _9) {
        this._9 = _9;
    }

    public Double get_10() {
        return _10;
    }

    public void set_10(Double _10) {
        this._10 = _10;
    }

    public Float get_11() {
        return _11;
    }

    public void set_11(Float _11) {
        this._11 = _11;
    }

    public BigDecimal get_12() {
        return _12;
    }

    public void set_12(BigDecimal _12) {
        this._12 = _12;
    }

    public Double get_13() {
        return _13;
    }

    public void set_13(Double _13) {
        this._13 = _13;
    }

    public Float get_14() {
        return _14;
    }

    public void set_14(Float _14) {
        this._14 = _14;
    }

    public Integer get_15() {
        return _15;
    }

    public void set_15(Integer _15) {
        this._15 = _15;
    }

    public Date get_16() {
        return _16;
    }

    public void set_16(Date _16) {
        this._16 = _16;
    }

    public Integer get_17() {
        return _17;
    }

    public void set_17(Integer _17) {
        this._17 = _17;
    }
}