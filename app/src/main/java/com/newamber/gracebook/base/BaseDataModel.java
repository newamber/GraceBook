package com.newamber.gracebook.base;

import java.util.Calendar;
import java.util.List;

/**
 * Description: A manager to collect all kinds of model types.<p>
 *
 * Created by Newamber on 2017/6/9.
 */
public interface BaseDataModel {
    /**
     * Description: Offer an universal interface to<br>
     *
     * {@link com.newamber.gracebook.model.entity.MoneyRepoTypePO} and<br>
     * {@link com.newamber.gracebook.model.entity.MoneyTypePO}.<p>
     * {@code E} means entity type.<br>
     */
    interface TypeModel<E> {

        void saveRecord();

        void deleteAllRecord();

        /**
         * Sometimes we only know the entity's index in adapter, so we can associate id and index.
         * (Usually, {@code id = index + 1})
         *
         * @param id the id of an record entity
         */
        void deleteRecordById(int id);

        /**
         * Swap a record to another position by long pressing and dragging.
         *
         * @param fromId record's start id which equals it's index plussing 1.
         * @param toId record's end id which also equals it's index plussing 1.
         *
         * @see com.newamber.gracebook.base.BaseRecyclerViewAdapter#onItemDragMove(int, int)
         * @see com.newamber.gracebook.util.other.ItemTouchActionHelper#onItemDragMove(int, int)
         */
        void dragSwap(int fromId, int toId);

        boolean isExist(String typeName);

        /**
         * Query a record by PrimaryKey: name.
         *
         * @param typeName the record's PrimaryKey
         * @return {@code E} if it exists and null if not
         */
        E queryByName(String typeName);

        List<E> getAllRecord();
    }

    interface AccountModel<E> {

        void saveRecord();

        List<E> getAllRecord();

        List<E> getRecordByDate(Calendar startDate, Calendar endDate);

    }
}
