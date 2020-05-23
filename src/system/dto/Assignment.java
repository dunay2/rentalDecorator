package system.dto;

import system.dto.state.Car;

import java.util.Date;

public class Assignment
{
    private Car car;
    private Date startDate;
    private Date endDate;
    public Date getEndDate()
    {
        return endDate;
    }
    public Integer getCarPricePerDay()
    {
        return car.getModelPricePerDay();
    }
    public String getCarLicensePlate()
    {
        return car.getLicensePlate();
    }

    public Assignment( Car car, Date startDate, Date endDate) {
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Car getCar()
    {
        return car;
    }
}

