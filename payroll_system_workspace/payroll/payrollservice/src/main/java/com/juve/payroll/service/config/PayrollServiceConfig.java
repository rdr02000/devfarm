package com.juve.payroll.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.juve.payroll.data.config.PayrollJPAConfig;


@Configuration
@ComponentScan({ "com.juve.payroll" })
@Import(PayrollJPAConfig.class)
public class PayrollServiceConfig {

}
