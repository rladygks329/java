
/**
 *  인터페이스는  백안의 오브젝트의 연산을 묘사해야합니다  
 * 
 */
public interface BagInterface<T> {
	
	// 백안의 현재 엔트리의 갯수를 가져옵니다.
	//그 백안의 엔트리의 현재 갯수를 return합니다
	public int getCurrentSize();
	
	//백이 비어있는지 보여주고 비어있으면 true 차있으면 false를 리턴합니다.
	public boolean isEmpty();
	
	/** 벡안에 new entry를 넣습니다.
	 *  @param newEntry 그 객체는 새로운 엔트리에 더해질수있습니다
	 *  @return 넣는데 성공했으면 true ,아니면 false를 return해줍니다.
	 */
	public boolean add(T newEntry);
	
	/** 백안에서 불특정한 entry를 제거합니다 가능하다면 말이죠;
	 * 
	 * @return Either the removed entry, if the removal was successful, or null
	 */
	public T remove();
	/**
	 * 이 백에 주어진 하나의 발생을 제거합니다 만약 가능하다면말이죠
	 * @param anEntry 지워질 엔트리
	 * @return 성공하면 트루 실패면 폴스
	 */
	public boolean remove(T anEntry);
	
	/**백안에 있는 엔트리를 모두 제거해라 */
	public void clear();
	
	/**
	 * 이 백에서 주어진 엔트리가 나타난 갯수를 세십시오 
	 * @param entry -계산할 엔트리
	 * @return 백에서 엔트리가 나타난 갯수를 반환하십시오
	 */
	public int getFrequencyOF(T entry);
	
	/**
	 * 이 백에 인트리가 들어갈수이쓴지 시험하십시오
	 * @param entry 위치할 엔트리
	 * @return 들어가면 트루 안들어가면 폴스
	 */
	public boolean contains(T entry);
	/**
	 * 백안에 모든 엔트리를 검색하ㅣㅂ시오
	 * @return 백안에 새롭게 할당된 모든 엔트리 배열
	 * 주의사항: 만약 백이 비어있다면  return 엔트리도 비어있음
	 */
	public T[] toArray();
	
	//백 인터페이스 끝
	
	

}
