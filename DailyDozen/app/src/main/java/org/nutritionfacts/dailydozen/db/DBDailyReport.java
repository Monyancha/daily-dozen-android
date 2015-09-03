package org.nutritionfacts.dailydozen.db;

import java.util.List;
import org.nutritionfacts.dailydozen.db.DaoSession;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
import java.util.ArrayList;
import java.util.Date;
import org.nutritionfacts.dailydozen.food.FoodHelper;
import org.nutritionfacts.dailydozen.food.FoodType;
// KEEP INCLUDES END
/**
 * Entity mapped to table DBDAILY_REPORT.
 */
public class DBDailyReport {

    private Long id;
    private java.util.Date date;
    private Long userId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient DBDailyReportDao myDao;

    private List<DBConsumption> consumptions;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public DBDailyReport() {
    }

    public DBDailyReport(Long id) {
        this.id = id;
    }

    public DBDailyReport(Long id, java.util.Date date, Long userId) {
        this.id = id;
        this.date = date;
        this.userId = userId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDBDailyReportDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<DBConsumption> getConsumptions() {
        if (consumptions == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DBConsumptionDao targetDao = daoSession.getDBConsumptionDao();
            List<DBConsumption> consumptionsNew = targetDao._queryDBDailyReport_Consumptions(id);
            synchronized (this) {
                if(consumptions == null) {
                    consumptions = consumptionsNew;
                }
            }
        }
        return consumptions;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetConsumptions() {
        consumptions = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
    public static DBDailyReport getDailyReportForDate(DaoSession session, Date date) {

        DBDailyReport dailyOverview = session
                .getDBDailyReportDao()
                .queryBuilder()
                .where(DBDailyReportDao.Properties.Date.eq(date)).unique();

        if (dailyOverview == null) {
            dailyOverview = initializeDailyReport(session, date);
        }

        for (DBConsumption consumption : dailyOverview.getConsumptions()) {
            consumption.foodType = FoodHelper.getInstance().getFoodTypeForIdentifier(consumption.getFoodTypeIdentifier());
        }

        return dailyOverview;
    }

    public static DBDailyReport initializeDailyReport(DaoSession session, Date date) {

        DBDailyReport dailyReport = new DBDailyReport();
        session.getDBDailyReportDao().insert(dailyReport);

        List<DBConsumption> consumptions = new ArrayList<>();

        //beans
        DBConsumption beans = new DBConsumption();
        consumptions.add(beans);
        beans.setFoodTypeIdentifier(FoodType.K_IDENTIFIER_BEANS);
        beans.setConsumedServingCount(0.0);
        beans.setDailyReportId(dailyReport.getId());

        //berries
        DBConsumption berries = new DBConsumption();
        consumptions.add(berries);
        berries.setFoodTypeIdentifier(FoodType.K_IDENTIFIER_BERRIES);
        berries.setConsumedServingCount(0.0);
        berries.setDailyReportId(dailyReport.getId());

        //other fruit
        DBConsumption otherFruit = new DBConsumption();
        consumptions.add(otherFruit);
        otherFruit.setFoodTypeIdentifier(FoodType.K_IDENTIFIER_OTHER_FRUIT);
        otherFruit.setConsumedServingCount(0.0);
        otherFruit.setDailyReportId(dailyReport.getId());

        //cruciferous
        DBConsumption cruciferous = new DBConsumption();
        consumptions.add(cruciferous);
        cruciferous.setFoodTypeIdentifier(FoodType.K_IDENTIFIER_CRUCIFEROUS);
        cruciferous.setConsumedServingCount(0.0);
        cruciferous.setDailyReportId(dailyReport.getId());

        //greens
        DBConsumption greens = new DBConsumption();
        consumptions.add(greens);
        greens.setFoodTypeIdentifier(FoodType.K_IDENTIFIER_GREENS);
        greens.setConsumedServingCount(0.0);
        greens.setDailyReportId(dailyReport.getId());

        //other vegetables
        DBConsumption otherVegetables = new DBConsumption();
        consumptions.add(otherVegetables);
        otherVegetables.setFoodTypeIdentifier(FoodType.K_IDENTIFIER_OTHER_VEG);
        otherVegetables.setConsumedServingCount(0.0);
        otherVegetables.setDailyReportId(dailyReport.getId());

        //flaxseeds
        DBConsumption flaxSeeds = new DBConsumption();
        consumptions.add(flaxSeeds);
        flaxSeeds.setFoodTypeIdentifier(FoodType.K_IDENTIFIER_FLAX);
        flaxSeeds.setConsumedServingCount(0.0);
        flaxSeeds.setDailyReportId(dailyReport.getId());

        //nuts
        DBConsumption nuts = new DBConsumption();
        consumptions.add(nuts);
        nuts.setFoodTypeIdentifier(FoodType.K_IDENTIFIER_NUTS);
        nuts.setConsumedServingCount(0.0);
        nuts.setDailyReportId(dailyReport.getId());

        //spices
        DBConsumption spices = new DBConsumption();
        consumptions.add(spices);
        spices.setFoodTypeIdentifier(FoodType.K_IDENTIFIER_SPICES);
        spices.setConsumedServingCount(0.0);
        spices.setDailyReportId(dailyReport.getId());

        //whole grains
        DBConsumption wholeGrains = new DBConsumption();
        consumptions.add(wholeGrains);
        wholeGrains.setFoodTypeIdentifier(FoodType.K_IDENTIFIER_WHOLE_GRAINS);
        wholeGrains.setConsumedServingCount(0.0);
        wholeGrains.setDailyReportId(dailyReport.getId());

        //beverages
        DBConsumption beverages = new DBConsumption();
        consumptions.add(beverages);
        beverages.setFoodTypeIdentifier(FoodType.K_IDENTIFIER_BEVERAGES);
        beverages.setConsumedServingCount(0.0);
        beverages.setDailyReportId(dailyReport.getId());

        //exercises
        DBConsumption exercises = new DBConsumption();
        consumptions.add(exercises);
        exercises.setFoodTypeIdentifier(FoodType.K_IDENTIFIER_EXERCISES);
        exercises.setConsumedServingCount(0.0);
        exercises.setDailyReportId(dailyReport.getId());

        session.getDBConsumptionDao().insertInTx(consumptions);
        session.getDBConsumptionDao().updateInTx(consumptions);

        dailyReport.resetConsumptions();

        dailyReport.setDate(date);
        dailyReport.update();

        return dailyReport;
    }
    // KEEP METHODS END

}
