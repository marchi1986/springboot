package com.example.springbootjpa.specs;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import static com.google.common.collect.Iterables.toArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CustomerSpecs {

    //1定义一个返回值为Specification的方法byAuto,这里使用的泛型T，所以这个Specification是可以用于任意的实体类的。它接受的参数是entityMananger和当前的包含值作为查询条件的实体对象
    //2获取当前实体类对象的类型
    //3新建Predicate列表存储构造的查询条件
    //4获得实体类的EntityType，我们可以从EntityType获得实体类的属性
    //5对实体类的所有属性做循环
    //6获取实体类对象某一个属性的值
    //7
    //8
    //9构造当前属性like属性值查询条件，并添加到条件列表中
    //10其余情况下，构造属性和属性值equal查询条件，并添加到条件列表


    public static <T> Specification<T> byAuto(final EntityManager entityManager,final T example){//1
        final  Class<T> type=(Class<T>) example.getClass();//2

        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates=new ArrayList<>();//3

                EntityType<T> entity=entityManager.getMetamodel().entity(type);//4

                for (Attribute<T,?> attr:entity.getDeclaredAttributes()){//5
                    Object attrValue=getValue(example,attr);//6
                    if(attrValue!=null){
                        if(attr.getJavaType()==String.class){//7
                            if(!StringUtils.isEmpty(attrValue)){//8
                                String condition=pattern((String)attrValue);
                                predicates.add(cb.like(root.get(attribute(entity,attr.getName(),String.class)),condition));//9
                            }
                        }else{
                            predicates.add(cb.equal(root.get(attribute(entity,attr.getName(),attrValue.getClass())),attrValue));//10
                        }
                    }
                }
                return predicates.isEmpty()?cb.conjunction():cb.and(toArray(predicates,Predicate.class));//11
            }

            /**
             * 12通过反射获得实体类对象对应属性的属性值
             * @param example
             * @param attr
             * @param <T>
             * @return
             */
            private <T> Object getValue(T example,Attribute<T,?> attr){
                return ReflectionUtils.getField((Field)attr.getJavaMember(),example);
            }

            /**
             * 13获得实体类的当前属性的SingularAttribute，SingularAttribute包含的是实体类的某个单独属性
             * @param entity
             * @param fieldName
             * @param fieldClass
             * @param <E>
             * @param <T>
             * @return
             */
            private <E,T> SingularAttribute<T,E> attribute(EntityType<T> entity,String fieldName,Class<E> fieldClass){
                return entity.getDeclaredSingularAttribute(fieldName,fieldClass);
            }
        };
    }

    /**
     * 构造like的查询模式
     * @param str
     * @return
     */
    static private String pattern(String str){
        System.out.println(str);
        return  "%"+str+"%";
    }
}
