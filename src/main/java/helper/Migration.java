package helper;

import annotation.Column;
import annotation.Entity;
import annotation.Id;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Set;

public class Migration {
    public static void main(String[] args) throws SQLException {
        Reflections reflections = new Reflections("entity");
        Set<Class<?>> allClasses =
                reflections.getTypesAnnotatedWith(Entity.class);
        for (Class<?> c :
                allClasses) {
            registerClass(c);
        }
    }
    public static void registerClass(Class clazz) throws SQLException {
        try {
            if (!clazz.isAnnotationPresent(Entity.class)) {
                return;
            }
            Entity entityInfor = (Entity) clazz.getAnnotation(Entity.class);
            StringBuilder strQuery = new StringBuilder();
            strQuery.append(SQLConstant.CREATE_TABLE);
            strQuery.append(SQLConstant.SPACE);
            strQuery.append(entityInfor.tableName());
            strQuery.append(SQLConstant.SPACE);
            strQuery.append(SQLConstant.OPEN_PARENTHESES);
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                if (!field.isAnnotationPresent(Column.class)) {
                    continue;
                }
                Column columnInfor = (Column) field.getAnnotation(Column.class);
                strQuery.append(columnInfor.columnName());
                strQuery.append(SQLConstant.SPACE);
                strQuery.append(columnInfor.columnType());
                if (field.isAnnotationPresent(Id.class)) {
                    Id idInfor = (Id) field.getAnnotation(Id.class);
                    strQuery.append(SQLConstant.SPACE);
                    strQuery.append(SQLConstant.PRIMARY_KEY);
                    if (idInfor.autoIncrement()) {
                        strQuery.append(SQLConstant.SPACE);
                        strQuery.append(SQLConstant.AUTO_INCREMENT);
                    }
                }
                strQuery.append(SQLConstant.COMMA);
                strQuery.append(SQLConstant.SPACE);
            }
            strQuery.setLength(strQuery.length() - 2);
            strQuery.append(SQLConstant.CLOSE_PARENTHESES);
            ConnectionHelper.getConnection().createStatement().execute(strQuery.toString());
            System.out.printf("T???o b???ng %s th??nh c??ng.\n", entityInfor.tableName());
        } catch (java.sql.SQLSyntaxErrorException sqlSyntaxErrorException) {
            System.err.printf("C?? l???i x???y ra trong qu?? tr??nh t???o b???ng. Error %s.\n", sqlSyntaxErrorException.getMessage());
        }
    }
}
