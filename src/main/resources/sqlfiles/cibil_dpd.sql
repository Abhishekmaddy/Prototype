SET @customerid={0};
SET @DPD={0};
SET @PaymentStartDate={0};
SET @PaymentEndDate={0};
SET @accountSegmentId={0};

SET @transactionid=(select id from cibil.transaction where zest_customer_id = @customerid order by id desc);
SET @responseId=(select id from cibil.response_segments where transaction_id= @transactionid);
SET @accountId =(select id FROM cibil.account_segment where response_segments_id =@responseId);

UPDATE `cibil`.`account_segment` SET `account_type` = @accountSegmentId, `payment_history1` = concat('0000000', @DPD, '00000000'), `payment_history2` = NULL, `payment_history_start_date` = @PaymentStartDate, `payment_history_end_date` = @PaymentEndDate WHERE (`id` = @accountId);