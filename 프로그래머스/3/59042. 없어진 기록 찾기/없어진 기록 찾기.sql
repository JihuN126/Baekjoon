SELECT ANIMAL_ID, NAME FROM ANIMAL_OUTS
WHERE NOT EXISTS(SELECT 1 FROM ANIMAL_INS
                WHERE ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID);